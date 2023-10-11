package andreas311.miso.domain.email.service

import andreas311.miso.domain.email.presentation.data.request.EmailCheckRequestDto

interface EmailCheckService {

    fun execute(emailCheckRequestDto: EmailCheckRequestDto)
}