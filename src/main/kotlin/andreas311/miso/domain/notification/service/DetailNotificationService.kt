package andreas311.miso.domain.notification.service

import andreas311.miso.domain.notification.presentation.data.response.DetailNotificationResponseDto

interface DetailNotificationService {

    fun execute(id: Long): DetailNotificationResponseDto
}