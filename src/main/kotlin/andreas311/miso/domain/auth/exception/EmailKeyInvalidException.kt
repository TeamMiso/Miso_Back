package andreas311.miso.domain.auth.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class EmailKeyInvalidException : MisoException(ErrorCode.EMAIL_KEY_IS_INVALID) {
}