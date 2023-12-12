package andreas311.miso.domain.notification.service.impl

import andreas311.miso.domain.inquiry.entity.Inquiry
import andreas311.miso.domain.inquiry.enums.InquiryStatus
import andreas311.miso.domain.notification.entity.data.NotificationAlarm
import andreas311.miso.domain.notification.enums.NotificationType
import andreas311.miso.domain.notification.service.NotificationSendService
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.util.FcmUtil

@RollbackService
class NotificationSendServiceImpl(
    private val fcmUtil: FcmUtil,
) : NotificationSendService {

    override fun execute(inquiry: Inquiry, token: String) {
        val notificationType = when (inquiry.inquiryStatus) {
            InquiryStatus.ADOPT -> NotificationType.INQUIRY_ADOPT
            InquiryStatus.UNADOPT -> NotificationType.INQUIRY_UNADOPT
            InquiryStatus.WAIT -> NotificationType.INQUIRT_WAIT
        }

        runCatching {
            fcmUtil.sendNotification(
                deviceToken = token,
                notificationAlarm = NotificationAlarm(
                    title = notificationType.title,
                    content = notificationType.content,
                    writer = "미소"
                )
            )

        }.onFailure {
            it.printStackTrace()
        }
    }
}