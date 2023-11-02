package andreas311.miso.domain.recyclables.service

import andreas311.miso.domain.recyclables.presentation.data.response.SearchRecyclablesResponseDto

interface SearchRecyclablesService {

    fun execute(searchValue: String): SearchRecyclablesResponseDto
}