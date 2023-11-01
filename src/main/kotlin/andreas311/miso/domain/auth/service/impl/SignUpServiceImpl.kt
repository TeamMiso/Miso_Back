package andreas311.miso.domain.auth.service.impl

import andreas311.miso.domain.auth.exception.MismatchPasswordException
import andreas311.miso.domain.auth.exception.UserAlreadyExistException
import andreas311.miso.domain.auth.presentation.data.request.SignUpRequestDto
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

    override fun execute(signUpRequestDto: SignUpRequestDto) {

        if (userRepository.existsByEmail(signUpRequestDto.email)) {
            throw UserAlreadyExistException()
        }

        if (signUpRequestDto.password != signUpRequestDto.passwordCheck) {
            throw MismatchPasswordException()
        }

        emailSendService.execute(signUpRequestDto.email)

        val encodedPassword = passwordEncoder.encode(signUpRequestDto.password)

        val user = signUpRequestDto.toEntity(encodedPassword)

        userRepository.save(user)
    }
}