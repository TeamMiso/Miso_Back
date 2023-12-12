package andreas311.miso.domain.notification.service.impl

import andreas311.miso.domain.notification.entity.DeviceToken
import andreas311.miso.domain.notification.repository.DeviceTokenRepository
import andreas311.miso.domain.notification.service.SaveDeviceTokenService
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.util.UserUtil

@RollbackService
class SaveDeviceTokenServiceImpl(
    private val userUtil: UserUtil,
    private val deviceTokenRepository: DeviceTokenRepository
) : SaveDeviceTokenService {

    override fun execute(token: String) {

        val user = userUtil.currentUser()

        val deviceToken = deviceTokenRepository.findByUser(user)

        if (deviceToken == null) {
            deviceTokenRepository.save(
                DeviceToken(
                    id = 0L,
                    token = token,
                    user = user
                )
            )
        } else {
            deviceToken.updateDeviceToken(token)
        }
    }
}