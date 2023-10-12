package andreas311.miso.domain.purchase.presentation

import andreas311.miso.domain.purchase.service.PurchaseItemService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@RequestController("/purchase")
class PurchaseController(
  private val purchaseItemService: PurchaseItemService
) {

    @PostMapping("/{id}")
    fun purchase(@PathVariable id: Long): ResponseEntity<Void> =
        purchaseItemService.execute(id)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}