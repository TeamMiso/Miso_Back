package andreas311.miso.domain.notification.entity

import andreas311.miso.domain.inquiry.entity.Inquiry
import andreas311.miso.domain.user.entity.User
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class Notification(

    @Id
    @Column(name = "notification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "answer")
    val answer: String,

    @ManyToOne
    @JoinColumn(name = "inquiry_id")
    val inquiry: Inquiry,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
)
