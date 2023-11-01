package andreas311.miso.domain.inquiry.service

import andreas311.miso.domain.inquiry.entity.Inquiry
import andreas311.miso.domain.inquiry.presentation.data.request.WriteInquiryRequestDto
import org.springframework.web.multipart.MultipartFile

interface WriteInquiryService {

    fun execute(writeInquiryRequestDto: WriteInquiryRequestDto, multipartFile: MultipartFile?): Inquiry
}