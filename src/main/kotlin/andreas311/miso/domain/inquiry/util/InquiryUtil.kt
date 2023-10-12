package andreas311.miso.domain.inquiry.util

import andreas311.miso.domain.inquiry.entity.Inquiry
import andreas311.miso.domain.inquiry.repository.InquiryRepository
import org.springframework.stereotype.Component

@Component
class InquiryUtil(
    private val inquiryRepository: InquiryRepository
) {

    fun saveInquiry(inquiry: Inquiry) =
        inquiryRepository.save(inquiry)
}