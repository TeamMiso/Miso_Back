package andreas311.miso.domain.recyclables.repository

import andreas311.miso.domain.recyclables.entity.Recyclables

interface RecyclablesRepositoryCustom {

    fun findBySubTitle(searchValue: String): Recyclables?
}