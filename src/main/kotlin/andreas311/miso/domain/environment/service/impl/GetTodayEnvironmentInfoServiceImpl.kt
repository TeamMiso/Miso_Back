package andreas311.miso.domain.environment.service.impl

import andreas311.miso.domain.environment.presentation.data.response.EnvironmentInfoResponseDto
import andreas311.miso.domain.environment.repository.TodayEnvironmentRepository
import andreas311.miso.domain.environment.service.GetTodayEnvironmentInfoService
import andreas311.miso.global.annotation.ReadOnlyService

@ReadOnlyService
class GetTodayEnvironmentInfoServiceImpl(
    private val todayEnvironmentRepository: TodayEnvironmentRepository
) : GetTodayEnvironmentInfoService {

    override fun execute(): EnvironmentInfoResponseDto {

        val todayEnvironment = todayEnvironmentRepository.findAll().first()

        return EnvironmentInfoResponseDto(todayEnvironment)
    }
}