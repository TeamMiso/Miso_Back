package andreas311.miso.domain.environment.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class Environment(

    @Id
    @Column(name = "environment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title")
    val title: String,

    @Column(name = "content", length = 10000)
    val content: String,

    @Column(name = "imageUrl")
    val imageUrl: String,
)