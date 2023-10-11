package andreas311.miso.domain.auth.service

import andreas311.miso.domain.auth.presentation.data.dto.SignInDto
import andreas311.miso.domain.auth.presentation.data.response.SignInResponseDto

interface SignInService {

    fun execute(signInDto: SignInDto): SignInResponseDto
}