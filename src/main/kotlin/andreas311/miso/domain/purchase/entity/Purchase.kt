package andreas311.miso.domain.purchase.entity

import andreas311.miso.domain.item.entity.Item
import andreas311.miso.domain.user.entity.User
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class Purchase(

    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "item_id")
    val item: Item
)