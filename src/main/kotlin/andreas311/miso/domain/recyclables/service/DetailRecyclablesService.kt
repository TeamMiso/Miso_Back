package andreas311.miso.domain.recyclables.service

import andreas311.miso.domain.recyclables.enums.RecyclablesType
import andreas311.miso.domain.recyclables.presentation.data.response.DetailRecyclablesResponseDto

interface DetailRecyclablesService {

    fun execute(recyclablesType: RecyclablesType): DetailRecyclablesResponseDto
}