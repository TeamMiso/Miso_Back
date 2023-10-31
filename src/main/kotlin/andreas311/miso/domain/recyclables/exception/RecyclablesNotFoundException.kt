package andreas311.miso.domain.recyclables.exception

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class RecyclablesNotFoundException : MisoException(ErrorCode.RECYCLABLES_NOT_FOUND){
}