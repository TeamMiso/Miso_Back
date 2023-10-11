package andreas311.miso.domain.auth.util

import andreas311.miso.domain.auth.entity.RefreshToken
import andreas311.miso.domain.auth.presentation.data.dto.SignInDto
import andreas311.miso.domain.auth.presentation.data.request.SignInRequestDto
import andreas311.miso.domain.user.entity.User
import java.util.*

interface AuthConverter {

    fun toDto(signInRequestDto: SignInRequestDto): SignInDto

    fun toEntity(user: User): User

    fun toAdminEntity(user: User): User

    fun toEntity(userInfo: User, refreshToken: String): RefreshToken

    fun toEntity(userId: UUID?, refreshToken: String): RefreshToken
}