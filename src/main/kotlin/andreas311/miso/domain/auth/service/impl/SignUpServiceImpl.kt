package andreas311.miso.domain.auth.service.impl

import andreas311.miso.domain.auth.exception.MismatchPasswordException
import andreas311.miso.domain.auth.exception.UserAlreadyExistException
import andreas311.miso.domain.auth.presentation.data.request.SignUpRequest
import andreas311.miso.domain.auth.service.SignUpService
import andreas311.miso.domain.email.service.EmailSendService
import andreas311.miso.domain.user.repository.UserRepository
import andreas311.miso.global.annotation.RollbackService
import org.springframework.security.crypto.password.PasswordEncoder

@RollbackService
class SignUpServiceImpl(
    private val userRepository: UserRepository,
    private val emailSendService: EmailSendService,
    private val passwordEncoder: PasswordEncoder
) : SignUpService {
    override fun execute(signUpRequest: SignUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.email)) {
            throw UserAlreadyExistException()
        }

        if (signUpRequest.password != signUpRequest.passwordCheck) {
            throw MismatchPasswordException()
        }

        emailSendService.execute(signUpRequest.email)

        val encodedPassword = passwordEncoder.encode(signUpRequest.password)

        val user = signUpRequest.toEntity(encodedPassword)

        userRepository.save(user)
    }
}