package andreas311.miso.domain.user.presentation.data.response

import andreas311.miso.domain.user.entity.User
import andreas311.miso.domain.user.enums.Role
import java.util.UUID

data class UserInfoResponseDto(
    val id: UUID,
    val email: String,
    val password: String,
    val point: Int,
    val role: Role
) {
    constructor(user: User) : this (
        id = user.id,
        email = user.email,
        password = user.password,
        point = user.point,
        role = user.role[0]
    )
}