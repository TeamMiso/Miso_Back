package andreas311.miso.domain.notification.util

import andreas311.miso.domain.notification.entity.Notification
import andreas311.miso.domain.notification.repository.NotificationRepository
import org.springframework.stereotype.Component

@Component
class NotificationUtil(
    private val notificationRepository: NotificationRepository
) {

    fun saveNotification(notification: Notification) =
        notificationRepository.save(notification)
}