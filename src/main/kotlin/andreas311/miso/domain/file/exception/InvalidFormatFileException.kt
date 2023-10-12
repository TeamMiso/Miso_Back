package andreas311.miso.domain.file.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class InvalidFormatFileException : MisoException(ErrorCode.INVALID_FORMAT_FILE) {
}