package andreas311.miso.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {

    // SERVER ERROR
    UNKNOWN_ERROR(500, "알 수 없는 에러입니다."),

    // TOKEN
    TOKEN_IS_EXPIRED(401, "토큰이 만료 되었습니다."),
    TOKEN_NOT_VALID(401, "토큰이 유효 하지 않습니다."),
}