package andreas311.miso.domain.recyclables.service

import andreas311.miso.domain.recyclables.presentation.data.response.ListDetailRecyclablesResponseDto
import org.springframework.web.multipart.MultipartFile

interface ProcessRecyclablesImageService {

    fun execute(multipartFile: MultipartFile): ListDetailRecyclablesResponseDto
}