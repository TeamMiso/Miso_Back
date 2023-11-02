package andreas311.miso.domain.recyclables.service.impl

import andreas311.miso.domain.recyclables.exception.RecyclablesNotFoundException
import andreas311.miso.domain.recyclables.presentation.data.response.SearchRecyclablesResponseDto
import andreas311.miso.domain.recyclables.repository.RecyclablesRepository
import andreas311.miso.domain.recyclables.service.SearchRecyclablesService
import andreas311.miso.global.annotation.ReadOnlyService

@ReadOnlyService
class SearchRecyclablesServiceImpl(
    private val recyclablesRepository: RecyclablesRepository
) : SearchRecyclablesService {

    override fun execute(searchValue: String): SearchRecyclablesResponseDto {

        val recyclables = recyclablesRepository.findBySubTitle(searchValue)
            ?: throw RecyclablesNotFoundException()

        return SearchRecyclablesResponseDto(recyclables)
    }
}