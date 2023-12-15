package andreas311.miso.domain.environment.config

import andreas311.miso.domain.environment.entity.TodayEnvironment
import andreas311.miso.domain.environment.repository.EnvironmentRepository
import andreas311.miso.domain.environment.repository.TodayEnvironmentRepository
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class EnvironmentSettingConfig(
    private val environmentRepository: EnvironmentRepository,
    private val todayEnvironmentRepository: TodayEnvironmentRepository
) {

    @PostConstruct
    fun environmentSetting() {

        val environment = environmentRepository.findAll().shuffled().first()

        todayEnvironmentRepository.deleteAll()

        todayEnvironmentRepository.save(
            TodayEnvironment(
                id = 0L,
                title = environment.title,
                content = environment.content,
                imageUrl = environment.imageUrl
            )
        )
    }
}