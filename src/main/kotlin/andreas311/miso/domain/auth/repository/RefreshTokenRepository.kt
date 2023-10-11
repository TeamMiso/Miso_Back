package andreas311.miso.domain.auth.repository

import andreas311.miso.domain.auth.entity.RefreshToken
import org.springframework.data.repository.CrudRepository
import java.util.*

interface RefreshTokenRepository : CrudRepository<RefreshToken, UUID> {

    fun findByUserId(userId: UUID): RefreshToken?

    fun findByToken(token: String): RefreshToken?
}