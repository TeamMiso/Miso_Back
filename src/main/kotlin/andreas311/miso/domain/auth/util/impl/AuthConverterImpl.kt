package andreas311.miso.domain.auth.util.impl

import andreas311.miso.domain.auth.entity.RefreshToken
import andreas311.miso.domain.auth.presentation.data.dto.SignInDto
import andreas311.miso.domain.auth.presentation.data.request.SignInRequestDto
import andreas311.miso.domain.auth.util.AuthConverter
import andreas311.miso.domain.user.entity.User
import andreas311.miso.domain.user.enums.Role
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuthConverterImpl : AuthConverter {

    override fun toDto(signInRequestDto: SignInRequestDto): SignInDto =
        SignInDto(
            email = signInRequestDto.email,
            password = signInRequestDto.password
        )


    override fun toEntity(user: User): User =
        User(
            id = UUID.randomUUID(),
            email = user.email,
            password = user.password,
            point = 0,
            role = mutableListOf(Role.ROLE_USER)
        )

    override fun toAdminEntity(user: User): User =
        User(
            id = UUID.randomUUID(),
            email = user.email,
            password = user.password,
            point = 0,
            role = mutableListOf(Role.ROLE_ADMIN)
        )

    override fun toEntity(userInfo: User, refreshToken: String): RefreshToken =
        RefreshToken(
            userId = userInfo.id,
            token = refreshToken
        )


    override fun toEntity(userId: UUID?, refreshToken: String): RefreshToken =
        RefreshToken(
            userId = userId,
            token = refreshToken
        )
}