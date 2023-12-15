package andreas311.miso.domain.environment.schedule

import andreas311.miso.domain.environment.service.UpdateTodayEnvironmentService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class UpdateTodayEnvironmentSchedule(
    private val updateTodayEnvironmentService: UpdateTodayEnvironmentService
) {

    @Scheduled(cron = "0 0 0 * * ?")
    fun updateTodayEnvironment() {

        updateTodayEnvironmentService.execute()
    }
}