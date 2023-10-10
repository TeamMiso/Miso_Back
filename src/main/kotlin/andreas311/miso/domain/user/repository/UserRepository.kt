package andreas311.miso.domain.user.repository

import andreas311.miso.domain.user.entity.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<User, UUID> {
}