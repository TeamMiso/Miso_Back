package andreas311.miso.domain.inquiry.repository

import andreas311.miso.domain.inquiry.entity.Inquiry
import andreas311.miso.domain.inquiry.enums.InquiryStatus
import andreas311.miso.domain.user.entity.User
import org.springframework.data.repository.CrudRepository

interface InquiryRepository : CrudRepository<Inquiry, Long> {

    fun findAllByOrderByCreatedDateDesc(): List<Inquiry>

    fun findByUserOrderByCreatedDateDesc(user: User): List<Inquiry>?

    fun findAllByInquiryStatusOrderByCreatedDateDesc(inquiryStatus: InquiryStatus): List<Inquiry>

    fun findByUserAndInquiryStatusOrderByCreatedDateDesc(user: User, inquiryStatus: InquiryStatus): List<Inquiry>
}