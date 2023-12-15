package andreas311.miso.domain.environment.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class TodayEnvironment(

    @Id
    @Column(name = "today_environment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title")
    var title: String,

    @Column(name = "content", length = 5000)
    var content: String,

    @Column(name = "imageUrl")
    var imageUrl: String,
) {

    fun updateTodayEnvironment(environment: Environment) {
        title = environment.title
        content = environment.content
        imageUrl = environment.imageUrl
    }
}