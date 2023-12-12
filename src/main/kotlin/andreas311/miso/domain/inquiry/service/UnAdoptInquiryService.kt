package andreas311.miso.domain.inquiry.service

import andreas311.miso.domain.notification.entity.Notification
import andreas311.miso.domain.notification.presentation.data.request.WriteNotificationRequestDto

interface UnAdoptInquiryService {

    fun execute(id: Long, writeNotificationRequestDto: WriteNotificationRequestDto): Notification
}