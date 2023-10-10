package andreas311.miso.global.security.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class TokenExpiredException : MisoException(ErrorCode.TOKEN_IS_EXPIRED) {
}