package andreas311.miso.domain.auth.service.impl

import andreas311.miso.domain.auth.exception.EmailNotValidException
import andreas311.miso.domain.auth.exception.MismatchPasswordException
import andreas311.miso.domain.auth.exception.RoleNotExistException
import andreas311.miso.domain.auth.presentation.data.dto.SignInDto
import andreas311.miso.domain.auth.presentation.data.response.SignInResponseDto
import andreas311.miso.domain.auth.service.SignInService
import andreas311.miso.domain.auth.util.AuthUtil
import andreas311.miso.domain.email.repository.EmailRepository
import andreas311.miso.domain.user.entity.User
import andreas311.miso.domain.user.enums.Role
import andreas311.miso.domain.user.exception.UserNotFoundException
import andreas311.miso.domain.user.repository.UserRepository
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.security.jwt.TokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.ZonedDateTime

@RollbackService
class SignInServiceImpl(
    private val authUtil: AuthUtil,
    private val tokenProvider: TokenProvider,
    private val userRepository: UserRepository,
    private val emailRepository: EmailRepository,
    private val passwordEncoder: PasswordEncoder
) : SignInService {

    override fun execute(signInDto: SignInDto): SignInResponseDto {

        val user = userRepository.findByEmail(signInDto.email)
            ?: throw UserNotFoundException()

        val email = emailRepository.findByEmail(signInDto.email)

        if (!email.authentication) {
            throw EmailNotValidException()
        }

        val role = getRoleByUserInfo(user.role.toString(), user.email)

        if (!passwordEncoder.matches(signInDto.password, user.password)) {
            throw MismatchPasswordException()
        }

        val accessToken: String = tokenProvider.generateAccessToken(user.email)
        val refreshToken: String = tokenProvider.generateRefreshToken(user.email)
        val accessExp: ZonedDateTime = tokenProvider.accessExpiredTime
        val refreshExp: ZonedDateTime = tokenProvider.refreshExpiredTime

        when (role) {
            Role.ROLE_ADMIN -> {
                createAdminOrRefreshToken(user, refreshToken)
            }
            Role.ROLE_USER -> {
                createUserOrRefreshToken(user, refreshToken)
            }
        }

        return SignInResponseDto(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessExp = accessExp,
            refreshExp = refreshExp
        )
    }

    private fun getRoleByUserInfo(role: String, email: String): Role {
        val user = userRepository.findByEmail(email) ?:
        return when (role) {
            "ROLE_USER" -> Role.ROLE_USER
            "ROLE_ADMIN" -> Role.ROLE_ADMIN
            else -> throw RoleNotExistException()
        }
        return Role.ROLE_USER
    }

    private fun createUserOrRefreshToken(user: User, refreshToken: String) {
        val userInfo = userRepository.findByEmail(user.email)
        if (userInfo == null) {
            authUtil.saveNewUser(user, refreshToken)
        } else {
            authUtil.saveNewRefreshToken(userInfo, refreshToken)
        }
    }

    private fun createAdminOrRefreshToken(user: User, refreshToken: String) {
        val adminInfo = userRepository.findByEmail(user.email)
        if (adminInfo == null) {
            authUtil.saveNewAdmin(user, refreshToken)
        } else {
            authUtil.saveNewRefreshToken(adminInfo, refreshToken)
        }
    }
}