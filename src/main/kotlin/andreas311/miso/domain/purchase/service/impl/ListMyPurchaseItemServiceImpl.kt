package andreas311.miso.domain.purchase.service.impl

import andreas311.miso.domain.purchase.exception.PurchaseNotFoundException
import andreas311.miso.domain.purchase.presentation.data.response.ListMyPurchaseItemResponseDto
import andreas311.miso.domain.purchase.presentation.data.response.MyPurchaseItemResponseDto
import andreas311.miso.domain.purchase.repository.PurchaseRepository
import andreas311.miso.domain.purchase.service.ListMyPurchaseItemService
import andreas311.miso.global.annotation.ReadOnlyService
import andreas311.miso.global.util.UserUtil

@ReadOnlyService
class ListMyPurchaseItemServiceImpl(
    private val userUtil: UserUtil,
    private val purchaseRepository: PurchaseRepository
) : ListMyPurchaseItemService {

    override fun execute(): ListMyPurchaseItemResponseDto {

        val user = userUtil.currentUser()

        val purchase = purchaseRepository.findAllByUser(user)
            ?: throw PurchaseNotFoundException()

        return ListMyPurchaseItemResponseDto(
            purchaseList = purchase.map { MyPurchaseItemResponseDto(it) }
        )
    }
}