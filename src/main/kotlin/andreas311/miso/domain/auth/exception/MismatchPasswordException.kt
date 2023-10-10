package andreas311.miso.domain.auth.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class MismatchPasswordException : MisoException(ErrorCode.MISMATCH_PASSWORD) {
}