package andreas311.miso.domain.purchase.service.impl

import andreas311.miso.domain.item.presentation.data.response.ItemResponseDto
import andreas311.miso.domain.item.presentation.data.response.ListItemResponseDto
import andreas311.miso.domain.purchase.exception.PurchaseNotFoundException
import andreas311.miso.domain.purchase.repository.PurchaseRepository
import andreas311.miso.domain.purchase.service.ListMyPurchaseItemService
import andreas311.miso.global.annotation.ReadOnlyService
import andreas311.miso.global.util.UserUtil

@ReadOnlyService
class ListMyPurchaseItemServiceImpl(
    private val userUtil: UserUtil,
    private val purchaseRepository: PurchaseRepository
) : ListMyPurchaseItemService {

    override fun execute(): ListItemResponseDto {

        val user = userUtil.currentUser()

        val purchase = purchaseRepository.findAllByUser(user)
            ?: throw PurchaseNotFoundException()

        return ListItemResponseDto(
            itemList = purchase.map { ItemResponseDto(it) }
        )
    }
}