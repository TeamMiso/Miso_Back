package andreas311.miso.global.config.notification.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "fcm")
class FcmProperties(
    val url: String
)