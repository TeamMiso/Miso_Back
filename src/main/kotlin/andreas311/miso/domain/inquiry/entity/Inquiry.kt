package andreas311.miso.domain.inquiry.entity

import andreas311.miso.domain.inquiry.enums.InquiryStatus
import andreas311.miso.domain.user.entity.User
import andreas311.miso.global.entity.BaseTimeEntity
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class Inquiry(

    @Id
    @Column(name = "inquiry_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title", length = 100)
    val title: String,

    @Column(name = "content", length = 500)
    val content: String,

    @Column(name = "imageUrl")
    val imageUrl: String?,

    @Enumerated(EnumType.STRING)
    @Column(name = "inquiryStatus")
    var inquiryStatus: InquiryStatus,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
) : BaseTimeEntity() {
    fun updateInquiryStatus(inquiryStatus: InquiryStatus) {
        this.inquiryStatus = inquiryStatus
    }
}