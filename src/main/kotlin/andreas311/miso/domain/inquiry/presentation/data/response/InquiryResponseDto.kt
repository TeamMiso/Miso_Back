package andreas311.miso.domain.inquiry.presentation.data.response

import andreas311.miso.domain.inquiry.entity.Inquiry
import andreas311.miso.domain.inquiry.enums.InquiryStatus
import java.time.LocalDateTime

data class InquiryResponseDto(
    val id: Long,
    val inquiryDate: LocalDateTime,
    val title: String,
    val inquiryStatus: InquiryStatus
) {
    constructor(inquiry: Inquiry) : this(
        id = inquiry.id,
        inquiryDate = inquiry.createdDate,
        title = inquiry.title,
        inquiryStatus = inquiry.inquiryStatus
    )
}
