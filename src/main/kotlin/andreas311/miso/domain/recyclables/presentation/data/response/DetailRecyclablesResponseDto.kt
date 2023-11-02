package andreas311.miso.domain.recyclables.presentation.data.response

import andreas311.miso.domain.recyclables.entity.Recyclables
import andreas311.miso.domain.recyclables.enums.RecyclablesType

data class DetailRecyclablesResponseDto(
    val id: Long,
    val title: String,
    val subTitle: String,
    val content: String,
    val imageUrl: String,
    val recyclablesType: RecyclablesType,
    val recycleMark: String
) {
    constructor(recyclables: Recyclables) : this(
        id = recyclables.id,
        title = recyclables.title,
        subTitle = recyclables.subTitle,
        content = recyclables.content,
        imageUrl = recyclables.imageUrl,
        recyclablesType = recyclables.recyclablesType,
        recycleMark = recyclables.recycleMark
    )
}
