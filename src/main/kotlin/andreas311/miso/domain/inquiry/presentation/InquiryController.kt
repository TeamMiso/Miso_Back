package andreas311.miso.domain.inquiry.presentation

import andreas311.miso.domain.inquiry.presentation.data.request.WriteInquiryRequestDto
import andreas311.miso.domain.inquiry.presentation.data.response.DetailInquiryResponseDto
import andreas311.miso.domain.inquiry.presentation.data.response.ListInquiryResponseDto
import andreas311.miso.domain.inquiry.service.DetailInquiryService
import andreas311.miso.domain.inquiry.service.ListAllInquiryService
import andreas311.miso.domain.inquiry.service.ListMyInquiryService
import andreas311.miso.domain.inquiry.service.WriteInquiryService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@RequestController("/inquiry")
class InquiryController(
    private val writeInquiryService: WriteInquiryService,
    private val listMyInquiryService: ListMyInquiryService,
    private val detailInquiryService: DetailInquiryService,
    private val listAllInquiryService: ListAllInquiryService
) {

    @PostMapping
    fun write(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "inquiry") writeInquiryRequestDto: WriteInquiryRequestDto
    ): ResponseEntity<Void> =
        writeInquiryService.execute(writeInquiryRequestDto, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping
    fun inquiryLog(): ResponseEntity<ListInquiryResponseDto> =
        listMyInquiryService.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/all")
    fun inquiryAll(): ResponseEntity<ListInquiryResponseDto> =
        listAllInquiryService.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<DetailInquiryResponseDto> =
        detailInquiryService.execute(id)
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

}