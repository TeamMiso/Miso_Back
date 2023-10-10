package andreas311.miso.domain.email.service.impl

import andreas311.miso.domain.email.repository.EmailRepository
import andreas311.miso.domain.email.service.EmailSendService
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.email.EmailSender

@RollbackService
class EmailSendServiceImpl(
    private val emailSender: EmailSender,
    private val emailRepository: EmailRepository
) : EmailSendService {
    override fun execute(email: String) {

        if (emailRepository.existsByEmail(email)) {
            emailRepository.deleteByEmail(email)
        }

        emailSender.execute(email)
    }
}