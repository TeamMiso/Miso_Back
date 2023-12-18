package andreas311.miso.domain.notification.service.impl

import andreas311.miso.domain.notification.entity.data.NotificationAlarm
import andreas311.miso.domain.notification.enums.NotificationType
import andreas311.miso.domain.notification.repository.DeviceTokenRepository
import andreas311.miso.domain.notification.service.EnvironmentNotificationSendService
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.util.FcmUtil

@RollbackService
class EnvironmentNotificationSendServiceImpl(
    private val fcmUtil: FcmUtil,
    private val deviceTokenRepository: DeviceTokenRepository
) : EnvironmentNotificationSendService {

    override fun execute() {

        runCatching {
            fcmUtil.sendEnvironmentNotification(
                deviceTokens = deviceTokenRepository.findAll().map { it.token },
                notificationAlarm = NotificationAlarm(
                    title = NotificationType.ENVIRONMENT.title,
                    content = NotificationType.ENVIRONMENT.content,
                    writer = "미소"
                )
            )

        }.onFailure {
            it.printStackTrace()
        }
    }
}