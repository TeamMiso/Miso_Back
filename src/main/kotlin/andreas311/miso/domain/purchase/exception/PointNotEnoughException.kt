package andreas311.miso.domain.purchase.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class PointNotEnoughException : MisoException(ErrorCode.POINT_IS_NOT_ENOUGH) {
}