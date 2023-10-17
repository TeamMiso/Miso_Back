package andreas311.miso.domain.inquiry.service

import andreas311.miso.domain.inquiry.presentation.data.response.DetailInquiryResponseDto

interface DetailInquiryService {

    fun execute(id: Long): DetailInquiryResponseDto
}