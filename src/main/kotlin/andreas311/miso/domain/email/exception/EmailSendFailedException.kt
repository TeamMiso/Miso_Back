package andreas311.miso.domain.email.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class EmailSendFailedException : MisoException(ErrorCode.EMAIL_SEND_FAIL) {
}