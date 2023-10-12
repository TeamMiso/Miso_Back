package andreas311.miso.domain.user.service

import andreas311.miso.domain.user.presentation.data.response.PointResponseDto

interface GetPointService {

    fun execute(): PointResponseDto
}