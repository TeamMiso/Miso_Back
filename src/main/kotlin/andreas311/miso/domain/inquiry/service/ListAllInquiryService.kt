package andreas311.miso.domain.inquiry.service

import andreas311.miso.domain.inquiry.presentation.data.response.ListInquiryResponseDto

interface ListAllInquiryService {

    fun execute(): ListInquiryResponseDto
}