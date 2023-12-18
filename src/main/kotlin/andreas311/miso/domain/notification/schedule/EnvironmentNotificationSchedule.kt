package andreas311.miso.domain.notification.schedule

import andreas311.miso.domain.notification.service.EnvironmentNotificationSendService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class EnvironmentNotificationSchedule(
    private val environmentNotificationSendService: EnvironmentNotificationSendService
) {

    @Scheduled(cron = "0 0 13 * * ?")
    fun sendEnvironmentNotification() {

        environmentNotificationSendService.execute()
    }
}