package andreas311.miso.domain.inquiry.service.impl

import andreas311.miso.domain.inquiry.exception.InquiryNotFoundException
import andreas311.miso.domain.inquiry.presentation.data.response.InquiryResponseDto
import andreas311.miso.domain.inquiry.presentation.data.response.ListInquiryResponseDto
import andreas311.miso.domain.inquiry.repository.InquiryRepository
import andreas311.miso.domain.inquiry.service.ListMyInquiryService
import andreas311.miso.global.annotation.ReadOnlyService
import andreas311.miso.global.util.UserUtil

@ReadOnlyService
class ListMyInquiryServiceImpl(
    private val userUtil: UserUtil,
    private val inquiryRepository: InquiryRepository
) : ListMyInquiryService {

    override fun execute(): ListInquiryResponseDto {

        val user = userUtil.currentUser()

        val inquiry = inquiryRepository.findByUser(user)
            ?: throw InquiryNotFoundException()

        return ListInquiryResponseDto(
            inquiryList = inquiry.map { InquiryResponseDto(it) }
        )
    }
}