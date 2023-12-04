package andreas311.miso.domain.recyclables.service

import andreas311.miso.domain.recyclables.presentation.data.response.DetailRecyclablesResponseDto
import org.springframework.web.multipart.MultipartFile

interface ProcessRecyclablesImageService {

    fun execute(multipartFile: MultipartFile): DetailRecyclablesResponseDto
}