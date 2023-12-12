package andreas311.miso.domain.notification.service

import andreas311.miso.domain.inquiry.entity.Inquiry

interface NotificationSendService {

    fun execute(inquiry: Inquiry, token: String)
}