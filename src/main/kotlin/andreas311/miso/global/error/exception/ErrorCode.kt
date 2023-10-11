package andreas311.miso.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {

    // SERVER ERROR
    UNKNOWN_ERROR(500, "알 수 없는 에러입니다."),

    // MAIL
    EMAIL_SEND_FAIL(500, "사용자를 찾을 수 없습니다."),

    // USER
    EMAIL_IS_NOT_VALID(403, "인증되지 않은 이메일입니다."),
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),
    ROLE_NOT_EXIST(404, "역할이 존재하지 않습니다"),
    USER_ALREADY_EXIST(409, "이미 사용자가 존재합니다."),
    MISMATCH_PASSWORD(400, "비밀번호가 일치하지 않습니다."),

    // TOKEN
    TOKEN_IS_EXPIRED(401, "토큰이 만료 되었습니다."),
    TOKEN_NOT_VALID(401, "토큰이 유효 하지 않습니다."),
}