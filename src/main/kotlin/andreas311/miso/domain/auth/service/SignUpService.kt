package andreas311.miso.domain.auth.service

import andreas311.miso.domain.auth.presentation.data.request.SignUpRequestDto

interface SignUpService {

    fun execute(signUpRequestDto: SignUpRequestDto)
}