package andreas311.miso.domain.auth.util

import andreas311.miso.domain.auth.entity.RefreshToken
import andreas311.miso.domain.user.entity.User

interface AuthUtil {

    fun saveNewUser(user: User, refreshToken: String)

    fun saveNewAdmin(user: User, refreshToken: String)

    fun saveNewRefreshToken(user: User, refreshToken: String): RefreshToken
}