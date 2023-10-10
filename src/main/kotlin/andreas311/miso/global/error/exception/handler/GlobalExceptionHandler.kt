package andreas311.miso.global.error.exception.handler

import andreas311.miso.global.error.exception.ErrorCode
import andreas311.miso.global.error.exception.MisoException
import andreas311.miso.global.error.exception.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class GlobalExceptionHandler {
    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    @ExceptionHandler(MisoException::class)
    fun globalExceptionHandler(request: HttpServletRequest, ex: MisoException): ResponseEntity<ErrorResponse> {
        log.error(ex.errorCode.message)

        log.error(request.requestURI)

        val errorCode: ErrorCode = ex.errorCode

        return ResponseEntity(
            ErrorResponse(status = errorCode.status, message = errorCode.message),
            HttpStatus.valueOf(errorCode.status)
        )
    }
}