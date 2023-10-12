package andreas311.miso.domain.inquiry.repository

import andreas311.miso.domain.inquiry.entity.Inquiry
import org.springframework.data.repository.CrudRepository

interface InquiryRepository : CrudRepository<Inquiry, Long> {
}