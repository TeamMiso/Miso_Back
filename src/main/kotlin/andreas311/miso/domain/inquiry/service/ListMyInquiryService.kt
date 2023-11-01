package andreas311.miso.domain.inquiry.service

import andreas311.miso.domain.inquiry.presentation.data.response.ListInquiryResponseDto

interface ListMyInquiryService {

    fun execute(): ListInquiryResponseDto
}