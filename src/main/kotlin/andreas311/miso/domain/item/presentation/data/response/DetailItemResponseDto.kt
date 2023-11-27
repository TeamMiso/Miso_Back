package andreas311.miso.domain.item.presentation.data.response

import andreas311.miso.domain.item.entity.Item

data class DetailItemResponseDto(
    val id: Long,
    val price: Int,
    val amount: Int,
    val name: String,
    val content: String,
    val imageUrl: String
){
    constructor(item: Item) : this(
        id = item.id,
        price = item.price,
        amount = item.amount,
        name = item.name,
        content = item.content,
        imageUrl = item.imageUrl
    )
}
