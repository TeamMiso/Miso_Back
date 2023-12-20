package andreas311.miso.domain.notification.presentation.data.response

import andreas311.miso.domain.notification.entity.Notification

data class DetailNotificationResponseDto(
    val answer: String
) {

    constructor(notification: Notification): this(
        answer = notification.answer
    )
}
