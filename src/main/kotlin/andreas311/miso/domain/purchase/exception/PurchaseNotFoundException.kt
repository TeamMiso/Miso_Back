package andreas311.miso.domain.purchase.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class PurchaseNotFoundException : MisoException(ErrorCode.PURCHASE_LOG_NOT_FOUND) {
}