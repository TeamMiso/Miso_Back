package andreas311.miso.domain.recyclables.service.impl

import andreas311.miso.domain.recyclables.presentation.data.response.ListSearchRecyclablesResponseDto
import andreas311.miso.domain.recyclables.presentation.data.response.SearchRecyclablesResponseDto
import andreas311.miso.domain.recyclables.repository.RecyclablesRepository
import andreas311.miso.domain.recyclables.service.ListAllRecyclablesService
import andreas311.miso.global.annotation.ReadOnlyService

@ReadOnlyService
class ListAllRecyclablesServiceImpl(
    private val recyclablesRepository: RecyclablesRepository
) : ListAllRecyclablesService {

    override fun execute(): ListSearchRecyclablesResponseDto = ListSearchRecyclablesResponseDto(
        recyclablesList = recyclablesRepository.findAllByOrderByTitleAsc()
            .map { SearchRecyclablesResponseDto(it) }
    )
}