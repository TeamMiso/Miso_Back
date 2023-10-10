package andreas311.miso.global.util

import org.springframework.stereotype.Component
import java.util.*

@Component
class EmailUtil {

    fun createRandomKey(): String {
        val random = Random()

        val randomKey = random.nextInt(888888) + 111111

        return randomKey.toString()
    }
}