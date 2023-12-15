package andreas311.miso.domain.notification.entity

import andreas311.miso.domain.user.entity.User
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class DeviceToken (

    @Id
    @Column(name = "device_token_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var token: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
) {

    fun updateDeviceToken(token: String) {
        this.token = token
    }
}