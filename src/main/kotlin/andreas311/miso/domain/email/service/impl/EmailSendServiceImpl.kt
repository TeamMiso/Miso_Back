package andreas311.miso.domain.email.service.impl

import andreas311.miso.domain.email.service.EmailSendService
import andreas311.miso.domain.user.repository.UserRepository
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.thirdparty.email.EmailSender

@RollbackService
class EmailSendServiceImpl(
    private val emailSender: EmailSender,
    private val userRepository: UserRepository
) : EmailSendService {

    override fun execute(email: String) {

        if (!userRepository.existsByEmail(email)) {
            emailSender.execute(email)
        }
    }
}