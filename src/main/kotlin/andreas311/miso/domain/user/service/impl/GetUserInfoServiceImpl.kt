package andreas311.miso.domain.user.service.impl

import andreas311.miso.domain.user.presentation.data.response.UserInfoResponseDto
import andreas311.miso.domain.user.service.GetUserInfoService
import andreas311.miso.global.annotation.ReadOnlyService
import andreas311.miso.global.util.UserUtil

@ReadOnlyService
class GetUserInfoServiceImpl(
    private val userUtil: UserUtil
) : GetUserInfoService {

    override fun execute(): UserInfoResponseDto {

        val user = userUtil.currentUser()

        return UserInfoResponseDto(user)
    }
}