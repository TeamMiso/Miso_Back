package andreas311.miso.domain.environment.presentation.data.response

import andreas311.miso.domain.environment.entity.TodayEnvironment

data class EnvironmentInfoResponseDto(
    val title: String,
    val content: String,
    val imageUrl: String
) {

    constructor(todayEnvironment: TodayEnvironment): this(
        title = todayEnvironment.title,
        content = todayEnvironment.content,
        imageUrl = todayEnvironment.imageUrl
    )
}
