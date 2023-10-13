package andreas311.miso.domain.inquiry.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class InquiryNotFoundException : MisoException(ErrorCode.INQUIRY_LOG_NOT_FOUND) {
}