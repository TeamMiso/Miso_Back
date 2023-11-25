package andreas311.miso.domain.item.presentation.data.response

import andreas311.miso.domain.item.entity.Item

data class ItemResponseDto(
    val id: Long,
    val price: Int,
    val name: String,
    val imageUrl: String
) {
    constructor(item: Item) : this(
        id = item.id,
        price = item.price,
        name = item.name,
        imageUrl = item.imageUrl
    )
}
