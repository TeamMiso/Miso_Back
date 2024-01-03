package andreas311.miso.domain.inquiry.service.impl

import andreas311.miso.domain.inquiry.presentation.data.response.InquiryResponseDto
import andreas311.miso.domain.inquiry.presentation.data.response.ListInquiryResponseDto
import andreas311.miso.domain.inquiry.repository.InquiryRepository
import andreas311.miso.domain.inquiry.service.ListInquiryService
import andreas311.miso.domain.user.enums.Role
import andreas311.miso.global.annotation.ReadOnlyService
import andreas311.miso.global.util.UserUtil

@ReadOnlyService
class ListInquiryServiceImpl(
    private val userUtil: UserUtil,
    private val inquiryRepository: InquiryRepository
) : ListInquiryService {

    override fun execute(): ListInquiryResponseDto {

        val user = userUtil.currentUser()

        val inquiry =
            if (user.role.equals(Role.ROLE_USER)) {
                inquiryRepository.findByUserOrderByCreatedDateDesc(user)
            } else {
                inquiryRepository.findAllByOrderByCreatedDateDesc()
            }

        return ListInquiryResponseDto(
            inquiryList = inquiry.map { InquiryResponseDto(it) }
        )
    }
}