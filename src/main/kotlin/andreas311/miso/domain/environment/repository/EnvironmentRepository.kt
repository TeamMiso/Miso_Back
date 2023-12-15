package andreas311.miso.domain.environment.repository

import andreas311.miso.domain.environment.entity.Environment
import org.springframework.data.repository.CrudRepository

interface EnvironmentRepository : CrudRepository<Environment, Long> {
}