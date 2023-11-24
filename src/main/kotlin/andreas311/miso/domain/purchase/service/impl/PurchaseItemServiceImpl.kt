package andreas311.miso.domain.purchase.service.impl

import andreas311.miso.domain.item.entity.Item
import andreas311.miso.domain.item.exception.ItemNotFoundException
import andreas311.miso.domain.item.repository.ItemRepository
import andreas311.miso.domain.purchase.entity.Purchase
import andreas311.miso.domain.purchase.exception.PointNotEnoughException
import andreas311.miso.domain.purchase.repository.PurchaseRepository
import andreas311.miso.domain.purchase.service.PurchaseItemService
import andreas311.miso.domain.user.entity.User
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.util.UserUtil
import org.springframework.data.repository.findByIdOrNull
import java.time.LocalDateTime

@RollbackService
class PurchaseItemServiceImpl(
    private val userUtil: UserUtil,
    private val itemRepository: ItemRepository,
    private val purchaseRepository: PurchaseRepository
) : PurchaseItemService {

    override fun execute(id: Long) {

        val user = userUtil.currentUser()

        val item = itemRepository.findByIdOrNull(id)
            ?: throw ItemNotFoundException()

        if (item.price > user.point) {
            throw PointNotEnoughException()
        }

        user.removePoint(item.price)

        purchaseRepository.save(toEntity(user, item))
    }

    private fun toEntity(user: User, item: Item): Purchase =
        Purchase(
            id = 0L,
            user = user,
            item = item,
            createdDate = LocalDateTime.now()
        )
}