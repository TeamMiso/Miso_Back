package andreas311.miso.domain.item.service.impl

import andreas311.miso.domain.item.presentation.data.response.ItemResponseDto
import andreas311.miso.domain.item.presentation.data.response.ListItemResponseDto
import andreas311.miso.domain.item.repository.ItemRepository
import andreas311.miso.domain.item.service.ListItemService
import andreas311.miso.global.annotation.ReadOnlyService

@ReadOnlyService
class ListItemServiceImpl(
    private val itemRepository: ItemRepository
) : ListItemService {

    override fun execute(): ListItemResponseDto = ListItemResponseDto(
        itemList = itemRepository.findAllByOrderByPriceAsc()
            .map { ItemResponseDto(it) }
    )
}