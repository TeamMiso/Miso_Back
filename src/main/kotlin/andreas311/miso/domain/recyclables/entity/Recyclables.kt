package andreas311.miso.domain.recyclables.entity

import andreas311.miso.domain.recyclables.enums.RecyclablesType
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class Recyclables(

    @Id
    @Column(name = "recyclables_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title")
    val title: String,

    @Column(name = "sub_title")
    val subTitle: String,

    @Column(name = "content", length = 10000)
    val content: String,

    @Column(name = "imageUrl")
    val imageUrl: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "recyclables_type")
    val recyclablesType: RecyclablesType,

    @Column(name = "recycle_mark")
    val recycleMark: String
)