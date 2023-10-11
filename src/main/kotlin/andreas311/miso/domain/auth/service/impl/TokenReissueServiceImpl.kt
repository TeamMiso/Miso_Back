package andreas311.miso.domain.auth.service.impl

import andreas311.miso.domain.auth.presentation.data.response.NewRefreshTokenResponseDto
import andreas311.miso.domain.auth.repository.RefreshTokenRepository
import andreas311.miso.domain.auth.service.TokenReissueService
import andreas311.miso.domain.auth.util.AuthConverter
import andreas311.miso.domain.user.enums.Role
import andreas311.miso.domain.user.exception.UserNotFoundException
import andreas311.miso.domain.user.repository.UserRepository
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.security.exception.TokenExpiredException
import andreas311.miso.global.security.exception.TokenInvalidException
import andreas311.miso.global.security.jwt.TokenProvider
import java.time.ZonedDateTime

@RollbackService
class TokenReissueServiceImpl(
    private val authConverter: AuthConverter,
    private val tokenProvider: TokenProvider,
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
) : TokenReissueService {

    override fun execute(refreshToken: String): NewRefreshTokenResponseDto {
        val refresh = tokenProvider.parseToken(refreshToken)
            ?: throw TokenInvalidException()

        val email: String = tokenProvider.exactEmailFromRefreshToken(refresh)

        val existingRefreshToken = refreshTokenRepository.findByToken(refresh)
            ?: throw TokenExpiredException()

        val newAccessToken = tokenProvider.generateAccessToken(email)
        val newRefreshToken = tokenProvider.generateRefreshToken(email)
        val accessExp: ZonedDateTime = tokenProvider.accessExpiredTime
        val refreshExp: ZonedDateTime = tokenProvider.refreshExpiredTime

        val newRefreshTokenEntity = authConverter.toEntity(
            userId = existingRefreshToken.userId,
            refreshToken = newRefreshToken
        )

        refreshTokenRepository.save(newRefreshTokenEntity)
        val user = userRepository.findByEmail(email)
            ?: throw UserNotFoundException()

        return NewRefreshTokenResponseDto(
            accessToken = newAccessToken,
            refreshToken = newRefreshToken,
            accessExp = accessExp,
            refreshExp = refreshExp
        )
    }
}