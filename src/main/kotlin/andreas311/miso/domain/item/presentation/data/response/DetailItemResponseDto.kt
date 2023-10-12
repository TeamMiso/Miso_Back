package andreas311.miso.domain.item.presentation.data.response

import andreas311.miso.domain.item.entity.Item

data class DetailItemResponseDto(
    val price: Int,
    val name: String,
    val content: String,
    val imageUrl: String
){
    constructor(item: Item) : this(
        price = item.price,
        name = item.name,
        content = item.content,
        imageUrl = item.imageUrl
    )
}
