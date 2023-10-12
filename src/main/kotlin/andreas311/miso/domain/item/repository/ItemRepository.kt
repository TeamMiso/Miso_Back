package andreas311.miso.domain.item.repository

import andreas311.miso.domain.item.entity.Item
import org.springframework.data.repository.CrudRepository

interface ItemRepository : CrudRepository<Item, Long> {
}