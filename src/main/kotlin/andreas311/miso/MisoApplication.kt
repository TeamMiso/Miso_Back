package andreas311.miso

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class MisoApplication

fun main(args: Array<String>) {
	runApplication<MisoApplication>(*args)
}
