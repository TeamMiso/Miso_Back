package andreas311.miso.global.error.exception

open class MisoException(
    val errorCode: ErrorCode
) : RuntimeException()