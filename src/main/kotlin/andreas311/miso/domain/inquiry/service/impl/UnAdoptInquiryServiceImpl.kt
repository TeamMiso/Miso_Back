package andreas311.miso.domain.inquiry.service.impl

import andreas311.miso.domain.inquiry.enums.InquiryStatus
import andreas311.miso.domain.inquiry.exception.InquiryNotFoundException
import andreas311.miso.domain.inquiry.repository.InquiryRepository
import andreas311.miso.domain.inquiry.service.UnAdoptInquiryService
import andreas311.miso.global.annotation.RollbackService
import org.springframework.data.repository.findByIdOrNull

@RollbackService
class UnAdoptInquiryServiceImpl(
    private val inquiryRepository: InquiryRepository
) : UnAdoptInquiryService {

    override fun execute(id: Long) {

        val inquiry = inquiryRepository.findByIdOrNull(id)
            ?: throw InquiryNotFoundException()

        inquiry.updateInquiryStatus(InquiryStatus.UNADOPT)
    }
}