package andreas311.miso.domain.item.service

import andreas311.miso.domain.item.presentation.data.response.ListItemResponseDto

interface ListItemService {

    fun execute(): ListItemResponseDto
}