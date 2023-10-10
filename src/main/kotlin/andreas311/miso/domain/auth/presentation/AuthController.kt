package andreas311.miso.domain.auth.presentation

import andreas311.miso.domain.auth.presentation.data.request.SignUpRequest
import andreas311.miso.domain.auth.service.SignUpService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RequestController("/auth")
class AuthController(
    private val signUpService: SignUpService
) {

    @PostMapping
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<Void> =
        signUpService.execute(signUpRequest)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}