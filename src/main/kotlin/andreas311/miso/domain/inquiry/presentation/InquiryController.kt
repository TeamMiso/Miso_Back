package andreas311.miso.domain.inquiry.presentation

import andreas311.miso.domain.inquiry.presentation.data.request.WriteInquiryRequestDto
import andreas311.miso.domain.inquiry.service.WriteInquiryService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@RequestController("/inquiry")
class InquiryController(
    private val writeInquiryService: WriteInquiryService
) {

    @PostMapping
    fun write(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "inquiry") writeInquiryRequestDto: WriteInquiryRequestDto
    ): ResponseEntity<Void> =
        writeInquiryService.execute(writeInquiryRequestDto, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

}