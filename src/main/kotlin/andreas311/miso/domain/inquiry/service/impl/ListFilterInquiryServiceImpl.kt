package andreas311.miso.domain.inquiry.service.impl

import andreas311.miso.domain.inquiry.enums.InquiryStatus
import andreas311.miso.domain.inquiry.presentation.data.response.InquiryResponseDto
import andreas311.miso.domain.inquiry.presentation.data.response.ListInquiryResponseDto
import andreas311.miso.domain.inquiry.repository.InquiryRepository
import andreas311.miso.domain.inquiry.service.ListFilterInquiryService
import andreas311.miso.domain.user.enums.Role
import andreas311.miso.global.annotation.ReadOnlyService
import andreas311.miso.global.util.UserUtil

@ReadOnlyService
class ListFilterInquiryServiceImpl(
    private val userUtil: UserUtil,
    private val inquiryRepository: InquiryRepository
) : ListFilterInquiryService {

    override fun execute(inquiryStatus: InquiryStatus): ListInquiryResponseDto {

        val user = userUtil.currentUser()

        val inquiry =
            if (user.role.equals(Role.ROLE_USER)) {
                inquiryRepository.findByUserAndInquiryStatusOrderByCreatedDateDesc(user, inquiryStatus)
            } else {
                inquiryRepository.findAllByInquiryStatusOrderByCreatedDateDesc(inquiryStatus)
            }

        return ListInquiryResponseDto(
            inquiryList = inquiry.map { InquiryResponseDto(it) }
        )
    }
}