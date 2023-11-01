package andreas311.miso.domain.recyclables.service.impl

import andreas311.miso.domain.recyclables.enums.RecyclablesType
import andreas311.miso.domain.recyclables.exception.RecyclablesNotFoundException
import andreas311.miso.domain.recyclables.presentation.data.response.RecyclablesResponseDto
import andreas311.miso.domain.recyclables.repository.RecyclablesRepository
import andreas311.miso.domain.recyclables.service.DetailRecyclablesService
import andreas311.miso.global.annotation.ReadOnlyService

@ReadOnlyService
class DetailRecyclablesServiceImpl(
    private val recyclablesRepository: RecyclablesRepository
) : DetailRecyclablesService {

    override fun execute(recyclablesType: RecyclablesType): RecyclablesResponseDto {

        val recyclables = recyclablesRepository.findByRecyclablesType(recyclablesType)
            ?: throw RecyclablesNotFoundException()

        return RecyclablesResponseDto(recyclables)
    }
}