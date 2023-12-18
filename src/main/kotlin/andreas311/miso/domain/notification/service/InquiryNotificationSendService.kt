package andreas311.miso.domain.notification.service

import andreas311.miso.domain.inquiry.entity.Inquiry

interface InquiryNotificationSendService {

    fun execute(inquiry: Inquiry, token: String)
}