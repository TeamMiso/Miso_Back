package andreas311.miso.domain.auth.service.impl

import andreas311.miso.domain.auth.exception.MismatchPasswordException
import andreas311.miso.domain.auth.exception.UserAlreadyExistException
import andreas311.miso.domain.auth.presentation.data.request.SignUpRequestDto
import andreas311.miso.domain.auth.service.SignUpService
import andreas311.miso.domain.email.repository.EmailRepository
import andreas311.miso.domain.email.service.EmailSendService
import andreas311.miso.domain.user.repository.UserRepository
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.email.EmailSender
import org.springframework.security.crypto.password.PasswordEncoder

@RollbackService
class SignUpServiceImpl(
    private val emailSender: EmailSender,
    private val userRepository: UserRepository,
    private val emailRepository: EmailRepository,
    private val emailSendService: EmailSendService,
    private val passwordEncoder: PasswordEncoder
) : SignUpService {

    override fun execute(signUpRequestDto: SignUpRequestDto) {

        emailSendService.execute(signUpRequestDto.email)

        val email = emailRepository.findByEmail(signUpRequestDto.email)

        if (userRepository.existsByEmail(signUpRequestDto.email) && email.authentication) {
            throw UserAlreadyExistException()
        } else if(userRepository.existsByEmail(signUpRequestDto.email)) {
            userRepository.deleteByEmail(signUpRequestDto.email)
            emailRepository.deleteByEmail(signUpRequestDto.email)
            emailSender.execute(signUpRequestDto.email)
        }

        if (signUpRequestDto.password != signUpRequestDto.passwordCheck) {
            throw MismatchPasswordException()
        }

        val encodedPassword = passwordEncoder.encode(signUpRequestDto.password)

        val user = signUpRequestDto.toEntity(encodedPassword)

        userRepository.save(user)
    }
}