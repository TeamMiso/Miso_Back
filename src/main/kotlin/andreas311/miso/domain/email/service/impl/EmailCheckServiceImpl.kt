package andreas311.miso.domain.email.service.impl

import andreas311.miso.domain.auth.exception.EmailKeyInvalidException
import andreas311.miso.domain.email.presentation.data.request.EmailCheckRequestDto
import andreas311.miso.domain.email.repository.EmailRepository
import andreas311.miso.domain.email.service.EmailCheckService
import andreas311.miso.global.annotation.RollbackService

@RollbackService
class EmailCheckServiceImpl(
    private val emailRepository: EmailRepository
) : EmailCheckService {

    override fun execute(emailCheckRequestDto: EmailCheckRequestDto) {

        val email = emailRepository.findByRandomKey(emailCheckRequestDto.randomKey)
            ?: throw EmailKeyInvalidException()

        email.updateAuthentication(true)
    }
}