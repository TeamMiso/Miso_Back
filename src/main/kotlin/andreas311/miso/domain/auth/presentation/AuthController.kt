package andreas311.miso.domain.auth.presentation

import andreas311.miso.domain.auth.presentation.data.request.SignInRequestDto
import andreas311.miso.domain.auth.presentation.data.request.SignUpRequestDto
import andreas311.miso.domain.auth.presentation.data.response.SignInResponseDto
import andreas311.miso.domain.auth.service.SignInService
import andreas311.miso.domain.auth.service.SignUpService
import andreas311.miso.domain.auth.util.AuthConverter
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@RequestController("/auth")
class AuthController(
    private val signUpService: SignUpService,
    private val signInService: SignInService,
    private val authConverter: AuthConverter
) {

    @PostMapping
    fun signUp(@RequestBody signUpRequestDto: SignUpRequestDto): ResponseEntity<Void> =
        signUpService.execute(signUpRequestDto)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PostMapping("/signIn")
    fun signIn(@Valid @RequestBody signInRequestDto: SignInRequestDto): ResponseEntity<SignInResponseDto> =
        authConverter.toDto(signInRequestDto)
            .let { ResponseEntity.ok(signInService.execute(it)) }
}