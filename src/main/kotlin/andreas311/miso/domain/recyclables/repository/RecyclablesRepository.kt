package andreas311.miso.domain.recyclables.repository

import andreas311.miso.domain.recyclables.entity.Recyclables
import andreas311.miso.domain.recyclables.enums.RecyclablesType
import org.springframework.data.repository.CrudRepository

interface RecyclablesRepository : CrudRepository<Recyclables, Long> {

    fun findByRecyclablesType(recyclablesType: RecyclablesType): Recyclables?
}