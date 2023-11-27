package andreas311.miso.domain.item.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class ItemSoldOutException : MisoException(ErrorCode.ITEM_IS_SOLD_OUT) {
}