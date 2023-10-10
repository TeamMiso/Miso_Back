package andreas311.miso.domain.email.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class Email(

    @Id
    @Column(name = "email_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "email")
    val email: String,

    @Column(name = "random_key")
    var randomKey: String,

    @Column(name = "authentication")
    var authentication: Boolean = false
) {
    fun updateRandomKey(randomKey: String) {
        this.randomKey = randomKey
    }

    fun updateAuthentication(authentication: Boolean) {
        this.authentication = authentication
    }
}