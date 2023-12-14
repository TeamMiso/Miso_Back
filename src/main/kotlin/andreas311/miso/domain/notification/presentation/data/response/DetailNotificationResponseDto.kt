package andreas311.miso.domain.notification.presentation.data.response

import andreas311.miso.domain.notification.entity.Notification

data class DetailNotificationResponseDto(
    val title: String,
    val content: String
) {

    constructor(notification: Notification): this(
        title = notification.title,
        content = notification.content
    )
}
