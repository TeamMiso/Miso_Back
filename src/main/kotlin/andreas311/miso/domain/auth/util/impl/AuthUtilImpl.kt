package andreas311.miso.domain.auth.util.impl

import andreas311.miso.domain.auth.entity.RefreshToken
import andreas311.miso.domain.auth.repository.RefreshTokenRepository
import andreas311.miso.domain.auth.util.AuthConverter
import andreas311.miso.domain.auth.util.AuthUtil
import andreas311.miso.domain.user.entity.User
import andreas311.miso.domain.user.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class AuthUtilImpl(
    private val authConverter: AuthConverter,
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository
) : AuthUtil {

    override fun saveNewUser(user: User, refreshToken: String) {
        val signInUserInfo: User = authConverter.toEntity(user)
            .let { userRepository.save(it) }
        saveNewRefreshToken(signInUserInfo, refreshToken)
    }

    override fun saveNewAdmin(user: User, refreshToken: String) {
        val signInUserInfo: User = authConverter.toAdminEntity(user)
            .let { userRepository.save(it) }
        saveNewRefreshToken(signInUserInfo, refreshToken)
    }

    override fun saveNewRefreshToken(user: User, refreshToken: String): RefreshToken {
        return authConverter.toEntity(user, refreshToken)
            .let { refreshTokenRepository.save(it) }
    }
}