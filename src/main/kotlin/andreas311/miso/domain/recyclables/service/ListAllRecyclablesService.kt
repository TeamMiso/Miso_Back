package andreas311.miso.domain.recyclables.service

import andreas311.miso.domain.recyclables.presentation.data.response.ListSearchRecyclablesResponseDto

interface ListAllRecyclablesService {

    fun execute(): ListSearchRecyclablesResponseDto
}