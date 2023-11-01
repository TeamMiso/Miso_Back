package andreas311.miso.domain.user.service

import andreas311.miso.domain.user.presentation.data.response.UserInfoResponseDto

interface GetUserInfoService {

    fun execute(): UserInfoResponseDto
}