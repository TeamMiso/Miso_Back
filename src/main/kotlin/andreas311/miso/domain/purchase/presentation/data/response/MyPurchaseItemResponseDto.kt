package andreas311.miso.domain.purchase.presentation.data.response

import andreas311.miso.domain.purchase.entity.Purchase
import java.time.LocalDateTime

data class MyPurchaseItemResponseDto(
    val id: Long,
    val price: Int,
    val name: String,
    val createdDate: LocalDateTime
) {
    constructor(purchase: Purchase) : this(
        id = purchase.item.id,
        price = purchase.item.price,
        name = purchase.item.name,
        createdDate = purchase.createdDate
    )
}