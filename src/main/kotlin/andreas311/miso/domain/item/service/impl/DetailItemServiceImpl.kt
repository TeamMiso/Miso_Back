package andreas311.miso.domain.item.service.impl

import andreas311.miso.domain.item.exception.ItemNotFoundException
import andreas311.miso.domain.item.presentation.data.response.DetailItemResponseDto
import andreas311.miso.domain.item.repository.ItemRepository
import andreas311.miso.domain.item.service.DetailItemService
import andreas311.miso.global.annotation.RollbackService
import org.springframework.data.repository.findByIdOrNull

@RollbackService
class DetailItemServiceImpl(
    private val itemRepository: ItemRepository
) : DetailItemService {
    override fun execute(id: Long): DetailItemResponseDto {

        val item = itemRepository.findByIdOrNull(id)
            ?: throw ItemNotFoundException()

        return DetailItemResponseDto(item)
    }
}