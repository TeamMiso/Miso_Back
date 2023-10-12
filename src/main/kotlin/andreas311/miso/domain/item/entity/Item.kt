package andreas311.miso.domain.item.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class Item(

    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "price")
    val price: Int,

    @Column(name = "name")
    val name: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "image_url")
    val imageUrl: String
)