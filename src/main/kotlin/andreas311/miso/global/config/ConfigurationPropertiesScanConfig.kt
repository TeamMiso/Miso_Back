package andreas311.miso.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(basePackages =
["andreas311.miso.global.config.redis.properties",
"andreas311.miso.global.security.jwt.properties",
"andreas311.miso.global.config.notification.properties"])
class ConfigurationPropertiesScanConfig