package andreas311.miso.domain.auth.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class UserAlreadyExistException : MisoException(ErrorCode.USER_ALREADY_EXIST) {
}