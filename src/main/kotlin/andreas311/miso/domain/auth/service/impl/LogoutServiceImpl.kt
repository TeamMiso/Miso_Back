package andreas311.miso.domain.auth.service.impl

import andreas311.miso.domain.auth.entity.RefreshToken
import andreas311.miso.domain.auth.repository.RefreshTokenRepository
import andreas311.miso.domain.auth.service.LogoutService
import andreas311.miso.domain.user.entity.User
import andreas311.miso.domain.user.exception.UserNotFoundException
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.util.UserUtil

@RollbackService
class LogoutServiceImpl(
    private val userUtil: UserUtil,
    private val refreshTokenRepository: RefreshTokenRepository
) : LogoutService {

    override fun execute() {
        val user: User = userUtil.currentUser()

        val refreshToken: RefreshToken = refreshTokenRepository.findByUserId(user.id)
            ?: throw UserNotFoundException()

        refreshTokenRepository.delete(refreshToken)
    }
}