package andreas311.miso.domain.inquiry.service.impl

import andreas311.miso.domain.file.service.FileService
import andreas311.miso.domain.inquiry.entity.Inquiry
import andreas311.miso.domain.inquiry.enums.InquiryStatus
import andreas311.miso.domain.inquiry.presentation.data.dto.WriteInquiryDto
import andreas311.miso.domain.inquiry.presentation.data.request.WriteInquiryRequestDto
import andreas311.miso.domain.inquiry.repository.InquiryRepository
import andreas311.miso.domain.inquiry.service.WriteInquiryService
import andreas311.miso.domain.inquiry.util.InquiryUtil
import andreas311.miso.domain.user.entity.User
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.util.UserUtil
import org.springframework.web.multipart.MultipartFile

@RollbackService
class WriteInquiryServiceImpl(
    private val userUtil: UserUtil,
    private val inquiryUtil: InquiryUtil,
    private val fileService: FileService,
    private val inquiryRepository: InquiryRepository
) : WriteInquiryService {

    override fun execute(writeInquiryRequestDto: WriteInquiryRequestDto, multipartFile: MultipartFile?): Inquiry {

        val user = userUtil.currentUser()

        val writeInquiryDto: WriteInquiryDto = toDto(writeInquiryRequestDto = writeInquiryRequestDto)

        if (multipartFile == null) {
            return toEntity(writeInquiryDto, user, imageUrl = null)
                .let { inquiryUtil.saveInquiry(inquiry = it) }
        }

        val imageUrl = fileService.execute(multipartFile)

        return toEntity(writeInquiryDto, user, imageUrl)
            .let { inquiryUtil.saveInquiry(inquiry = it) }
    }

    private fun toEntity(writeInquiryDto: WriteInquiryDto, user: User, imageUrl: String?): Inquiry =
        Inquiry(
            id = 0L,
            title = writeInquiryDto.title,
            content = writeInquiryDto.content,
            imageUrl = imageUrl,
            inquiryStatus = InquiryStatus.WAITING,
            user = user
        )

    private fun toDto(writeInquiryRequestDto: WriteInquiryRequestDto): WriteInquiryDto =
        WriteInquiryDto(
            title = writeInquiryRequestDto.title,
            content = writeInquiryRequestDto.content
        )
}