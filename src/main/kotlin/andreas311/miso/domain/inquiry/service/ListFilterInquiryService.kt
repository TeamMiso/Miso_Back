package andreas311.miso.domain.inquiry.service

import andreas311.miso.domain.inquiry.enums.InquiryStatus
import andreas311.miso.domain.inquiry.presentation.data.response.ListInquiryResponseDto

interface ListFilterInquiryService {

    fun execute(inquiryStatus: InquiryStatus): ListInquiryResponseDto
}