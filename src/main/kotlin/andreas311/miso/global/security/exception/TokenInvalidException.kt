package andreas311.miso.global.security.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class TokenInvalidException : MisoException(ErrorCode.TOKEN_NOT_VALID) {
}