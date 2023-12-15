package andreas311.miso.domain.notification.repository

import andreas311.miso.domain.notification.entity.Notification
import org.springframework.data.repository.CrudRepository

interface NotificationRepository : CrudRepository<Notification, Long> {

    fun findByInquiryId(id: Long): Notification?
}