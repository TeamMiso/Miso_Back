package andreas311.miso.domain.email.presentation

import andreas311.miso.domain.email.presentation.data.request.EmailCheckRequestDto
import andreas311.miso.domain.email.service.EmailCheckService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RequestController("/email")
class EmailController(
    private val emailCheckService: EmailCheckService
) {

    @PostMapping
    fun emailCheck(@RequestBody emailCheckRequestDto: EmailCheckRequestDto): ResponseEntity<Void> =
        emailCheckService.execute(emailCheckRequestDto)
            .let { ResponseEntity.status(HttpStatus.OK).build() }
}