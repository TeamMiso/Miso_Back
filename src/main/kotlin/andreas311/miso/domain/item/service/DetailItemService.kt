package andreas311.miso.domain.item.service

import andreas311.miso.domain.item.presentation.data.response.DetailItemResponseDto

interface DetailItemService {

    fun execute(id: Long): DetailItemResponseDto
}