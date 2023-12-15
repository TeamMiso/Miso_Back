package andreas311.miso.domain.recyclables.presentation.data.response

import andreas311.miso.domain.recyclables.entity.Recyclables
import andreas311.miso.domain.recyclables.enums.RecyclablesType

data class SearchRecyclablesResponseDto(
    val title: String,
    val imageUrl: String,
    val recycleMethod: String,
    val recyclablesType: RecyclablesType
) {
    constructor(recyclables: Recyclables) : this(
        title = recyclables.title,
        imageUrl = recyclables.imageUrl,
        recycleMethod = recyclables.recycleMethod,
        recyclablesType = recyclables.recyclablesType
    )
}