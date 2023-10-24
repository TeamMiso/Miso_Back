package andreas311.miso.domain.inquiry.service.impl

import andreas311.miso.domain.inquiry.presentation.data.response.InquiryResponseDto
import andreas311.miso.domain.inquiry.presentation.data.response.ListInquiryResponseDto
import andreas311.miso.domain.inquiry.repository.InquiryRepository
import andreas311.miso.domain.inquiry.service.ListAllInquiryService
import andreas311.miso.global.annotation.ReadOnlyService

@ReadOnlyService
class ListAllInquiryServiceImpl(
    private val inquiryRepository: InquiryRepository
) : ListAllInquiryService {

    override fun execute(): ListInquiryResponseDto {

        val inquiry = inquiryRepository.findAll()

        return ListInquiryResponseDto(
            inquiryList = inquiry.map { InquiryResponseDto(it) }
        )
    }
}