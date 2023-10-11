package andreas311.miso.domain.auth.service

import andreas311.miso.domain.auth.presentation.data.response.NewRefreshTokenResponseDto

interface TokenReissueService {

    fun execute(refreshToken: String): NewRefreshTokenResponseDto
}