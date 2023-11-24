package andreas311.miso.domain.purchase.service

import andreas311.miso.domain.purchase.presentation.data.response.ListMyPurchaseItemResponseDto

interface ListMyPurchaseItemService {

    fun execute(): ListMyPurchaseItemResponseDto
}