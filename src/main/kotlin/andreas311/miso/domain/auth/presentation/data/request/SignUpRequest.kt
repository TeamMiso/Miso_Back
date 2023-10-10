package andreas311.miso.domain.auth.presentation.data.request

import andreas311.miso.domain.user.entity.User
import andreas311.miso.domain.user.enums.Role
import java.util.*

data class SignUpRequest(
    val email: String,
    val password: String,
    val passwordCheck: String
) {
    fun toEntity(password: String): User =
        User(
            id = UUID.randomUUID(),
            email = email,
            password = password,
            role = mutableListOf(Role.ROLE_USER),
        )
}
