package andreas311.miso.domain.purchase.presentation

import andreas311.miso.domain.item.presentation.data.response.ListItemResponseDto
import andreas311.miso.domain.purchase.service.GetPurchaseItemService
import andreas311.miso.domain.purchase.service.PurchaseItemService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@RequestController("/purchase")
class PurchaseController(
  private val purchaseItemService: PurchaseItemService,
  private val getPurchaseItemService: GetPurchaseItemService
) {

    @GetMapping
    fun purchaseLog(): ResponseEntity<ListItemResponseDto> =
        getPurchaseItemService.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @PostMapping("/{id}")
    fun purchase(@PathVariable id: Long): ResponseEntity<Void> =
        purchaseItemService.execute(id)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}