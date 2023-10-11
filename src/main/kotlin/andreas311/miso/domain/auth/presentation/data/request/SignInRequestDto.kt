package andreas311.miso.domain.auth.presentation.data.request

import javax.validation.constraints.NotBlank

data class SignInRequestDto(
    @field:NotBlank
    val email: String,
    @field:NotBlank
    val password: String
)
