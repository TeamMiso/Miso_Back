package andreas311.miso.domain.inquiry.service.impl

import andreas311.miso.domain.inquiry.exception.InquiryNotFoundException
import andreas311.miso.domain.inquiry.presentation.data.response.DetailInquiryResponseDto
import andreas311.miso.domain.inquiry.repository.InquiryRepository
import andreas311.miso.domain.inquiry.service.DetailInquiryService
import andreas311.miso.global.annotation.ReadOnlyService
import org.springframework.data.repository.findByIdOrNull

@ReadOnlyService
class DetailInquiryServiceImpl(
    private val inquiryRepository: InquiryRepository
) : DetailInquiryService {

    override fun execute(id: Long): DetailInquiryResponseDto {

        val inquiry = inquiryRepository.findByIdOrNull(id)
            ?: throw InquiryNotFoundException()

        return DetailInquiryResponseDto(inquiry)
    }
}