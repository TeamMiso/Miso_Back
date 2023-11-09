package andreas311.miso.domain.user.entity

import andreas311.miso.domain.user.enums.Role
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@DynamicUpdate
class User(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    var id: UUID,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    var point: Int = 0,

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Role", joinColumns = [JoinColumn(name = "user_id")])
    val role: MutableList<Role>
) {

    fun addPoint(point: Int) {
        synchronized(this) {
            this.point += point
        }
    }

    fun removePoint(point: Int) {
        synchronized(this) {
            this.point -= point
        }
    }
}