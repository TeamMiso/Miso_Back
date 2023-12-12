package andreas311.miso.domain.notification.repository

import andreas311.miso.domain.notification.entity.DeviceToken
import andreas311.miso.domain.user.entity.User
import org.springframework.data.repository.CrudRepository

interface DeviceTokenRepository : CrudRepository<DeviceToken, Long> {

    fun findByUser(user: User): DeviceToken?
}