package andreas311.miso.domain.inquiry.repository

import andreas311.miso.domain.inquiry.entity.Inquiry
import andreas311.miso.domain.user.entity.User
import org.springframework.data.repository.CrudRepository

interface InquiryRepository : CrudRepository<Inquiry, Long> {

    fun findByUser(user: User): List<Inquiry>?
}