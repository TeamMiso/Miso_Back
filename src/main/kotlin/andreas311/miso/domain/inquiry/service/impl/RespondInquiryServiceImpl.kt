package andreas311.miso.domain.inquiry.service.impl

import andreas311.miso.domain.inquiry.entity.Inquiry
import andreas311.miso.domain.inquiry.enums.InquiryStatus
import andreas311.miso.domain.inquiry.exception.InquiryNotFoundException
import andreas311.miso.domain.inquiry.repository.InquiryRepository
import andreas311.miso.domain.inquiry.service.RespondInquiryService
import andreas311.miso.domain.notification.entity.Notification
import andreas311.miso.domain.notification.presentation.data.dto.WriteNotificationDto
import andreas311.miso.domain.notification.presentation.data.request.WriteNotificationRequestDto
import andreas311.miso.domain.notification.repository.DeviceTokenRepository
import andreas311.miso.domain.notification.service.InquiryNotificationSendService
import andreas311.miso.domain.notification.util.NotificationUtil
import andreas311.miso.domain.user.entity.User
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.util.UserUtil
import org.springframework.data.repository.findByIdOrNull

@RollbackService
class RespondInquiryServiceImpl(
    private val userUtil: UserUtil,
    private val notificationUtil: NotificationUtil,
    private val inquiryRepository: InquiryRepository,
    private val deviceTokenRepository: DeviceTokenRepository,
    private val inquiryNotificationSendService: InquiryNotificationSendService
) : RespondInquiryService {

    override fun execute(id: Long, writeNotificationRequestDto: WriteNotificationRequestDto): Notification {

        val user = userUtil.currentUser()

        val writeNotificationDto: WriteNotificationDto = toDto(writeNotificationRequestDto = writeNotificationRequestDto)

        val inquiry = inquiryRepository.findByIdOrNull(id)
            ?: throw InquiryNotFoundException()

        inquiry.updateInquiryStatus(InquiryStatus.COMPLETE)

        val token = deviceTokenRepository.findByUser(user)

        token?.let { inquiryNotificationSendService.execute(inquiry, token.token)}

        return toEntity(writeNotificationDto, user, inquiry)
            .let { notificationUtil.saveNotification(notification = it) }
    }

    private fun toEntity(writeNotificationDto: WriteNotificationDto, user: User, inquiry: Inquiry): Notification =
        Notification(
            id = 0L,
            answer = writeNotificationDto.answer,
            user = user,
            inquiry = inquiry
        )

    private fun toDto(writeNotificationRequestDto: WriteNotificationRequestDto): WriteNotificationDto =
        WriteNotificationDto(
            answer = writeNotificationRequestDto.answer
        )
}