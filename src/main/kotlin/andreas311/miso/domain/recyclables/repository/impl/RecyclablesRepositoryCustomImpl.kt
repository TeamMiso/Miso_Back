package andreas311.miso.domain.recyclables.repository.impl

import andreas311.miso.domain.recyclables.entity.QRecyclables
import andreas311.miso.domain.recyclables.entity.Recyclables
import andreas311.miso.domain.recyclables.repository.RecyclablesRepositoryCustom
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class RecyclablesRepositoryCustomImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : RecyclablesRepositoryCustom {

    override fun findBySubTitle(searchValue: String): Recyclables? {
        return jpaQueryFactory
            .selectFrom(QRecyclables.recyclables)
            .where(QRecyclables.recyclables.subTitle.like("%$searchValue%"))
            .fetchFirst()
    }
}

