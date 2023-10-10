package andreas311.miso.domain.email.repository

import andreas311.miso.domain.email.entity.Email
import org.springframework.data.repository.CrudRepository

interface EmailRepository : CrudRepository<Email, Long> {

    fun deleteByEmail(email: String)

    fun existsByEmail(email: String): Boolean
}