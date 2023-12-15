package andreas311.miso.domain.environment.repository

import andreas311.miso.domain.environment.entity.TodayEnvironment
import org.springframework.data.repository.CrudRepository

interface TodayEnvironmentRepository : CrudRepository<TodayEnvironment, Long> {
}