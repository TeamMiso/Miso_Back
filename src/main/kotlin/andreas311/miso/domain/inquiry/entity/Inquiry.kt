package andreas311.miso.domain.inquiry.entity

import andreas311.miso.domain.inquiry.enums.InquiryStatus
import andreas311.miso.domain.user.entity.User
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class Inquiry(

    @Id
    @Column(name = "inquiry_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title")
    val title: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "imageUrl")
    val imageUrl: String?,

    @Column(name = "inquiryStatus")
    val inquiryStatus: InquiryStatus,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
)