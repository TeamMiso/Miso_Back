package andreas311.miso.domain.purchase.repository

import andreas311.miso.domain.purchase.entity.Purchase
import andreas311.miso.domain.user.entity.User
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository : CrudRepository<Purchase, Long> {

    fun findAllByUserOrderByCreatedDateDesc(user: User): List<Purchase>?
}
