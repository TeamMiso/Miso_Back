package andreas311.miso.domain.auth.service

import andreas311.miso.domain.auth.presentation.data.request.SignUpRequest

interface SignUpService {

    fun execute(signUpRequest: SignUpRequest)
}