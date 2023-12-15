package andreas311.miso.domain.environment.service.impl

import andreas311.miso.domain.environment.entity.Environment
import andreas311.miso.domain.environment.repository.EnvironmentRepository
import andreas311.miso.domain.environment.repository.TodayEnvironmentRepository
import andreas311.miso.domain.environment.service.UpdateTodayEnvironmentService
import andreas311.miso.global.annotation.RollbackService

@RollbackService
class UpdateTodayEnvironmentServiceImpl(
    private val environmentRepository: EnvironmentRepository,
    private val todayEnvironmentRepository: TodayEnvironmentRepository
) : UpdateTodayEnvironmentService {

    override fun execute() {

        val todayEnvironment = todayEnvironmentRepository.findAll().first()

        val environment = getRandomEnvironment(todayEnvironment.title)

        todayEnvironment.updateTodayEnvironment(environment)
    }

    private fun getRandomEnvironment(title: String): Environment {

        val environments = environmentRepository.findAll().filterNot { it.title == title }
        return environments.shuffled().first()
    }
}
