package andreas311.miso.domain.purchase.service

import andreas311.miso.domain.item.presentation.data.response.ListItemResponseDto

interface GetPurchaseItemService {

    fun execute(): ListItemResponseDto
}