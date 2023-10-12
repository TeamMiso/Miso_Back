package andreas311.miso.domain.file.service

import org.springframework.web.multipart.MultipartFile

interface FileService {

    fun execute(multipartFile: MultipartFile): String
}