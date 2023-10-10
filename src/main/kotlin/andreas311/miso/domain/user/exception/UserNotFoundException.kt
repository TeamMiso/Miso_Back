package andreas311.miso.domain.user.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class UserNotFoundException : MisoException(ErrorCode.USER_NOT_FOUND) {
}