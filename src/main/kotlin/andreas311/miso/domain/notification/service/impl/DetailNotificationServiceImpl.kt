package andreas311.miso.domain.notification.service.impl

import andreas311.miso.domain.notification.exception.NotificationNotFoundException
import andreas311.miso.domain.notification.presentation.data.response.DetailNotificationResponseDto
import andreas311.miso.domain.notification.repository.NotificationRepository
import andreas311.miso.domain.notification.service.DetailNotificationService
import andreas311.miso.global.annotation.ReadOnlyService
import org.springframework.data.repository.findByIdOrNull

@ReadOnlyService
class DetailNotificationServiceImpl(
    private val notificationRepository: NotificationRepository
) : DetailNotificationService {

    override fun execute(id: Long): DetailNotificationResponseDto {

        val notification = notificationRepository.findByIdOrNull(id)
            ?: throw NotificationNotFoundException()

        return DetailNotificationResponseDto(notification)
    }
}