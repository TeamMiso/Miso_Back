package andreas311.miso.domain.user.service.impl

import andreas311.miso.domain.user.presentation.data.response.PointResponseDto
import andreas311.miso.domain.user.service.GetPointService
import andreas311.miso.global.annotation.ReadOnlyService
import andreas311.miso.global.util.UserUtil

@ReadOnlyService
class GetPointServiceImpl(
    private val userUtil: UserUtil
) : GetPointService {

    override fun execute(): PointResponseDto {

        val user = userUtil.currentUser()

        return PointResponseDto(user)
    }
}