package andreas311.miso.domain.notification.service.impl

import andreas311.miso.domain.inquiry.entity.Inquiry
import andreas311.miso.domain.inquiry.enums.InquiryStatus
import andreas311.miso.domain.notification.entity.data.NotificationAlarm
import andreas311.miso.domain.notification.enums.NotificationType
import andreas311.miso.domain.notification.service.InquiryNotificationSendService
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.thirdparty.fcm.FcmUtil

@RollbackService
class InquiryNotificationSendServiceImpl(
    private val fcmUtil: FcmUtil,
) : InquiryNotificationSendService {

    override fun execute(inquiry: Inquiry, token: String) {
        val notificationType = when (inquiry.inquiryStatus) {
            InquiryStatus.WAIT -> NotificationType.INQUIRY_WAIT
            InquiryStatus.COMPLETE -> NotificationType.INQUIRY_COMPLETE
        }

        runCatching {
            fcmUtil.sendInquiryNotification(
                deviceToken = token,
                notificationAlarm = NotificationAlarm(
                    title = notificationType.title,
                    body = notificationType.body,
                    writer = "미소"
                )
            )

        }.onFailure {
            it.printStackTrace()
        }
    }
}