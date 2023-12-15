package andreas311.miso.domain.environment.service

import andreas311.miso.domain.environment.presentation.data.response.EnvironmentInfoResponseDto

interface GetTodayEnvironmentInfoService {

    fun execute(): EnvironmentInfoResponseDto
}