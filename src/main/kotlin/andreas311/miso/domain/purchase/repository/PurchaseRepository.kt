package andreas311.miso.domain.purchase.repository

import andreas311.miso.domain.purchase.entity.Purchase
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository : CrudRepository<Purchase, Long> {
}