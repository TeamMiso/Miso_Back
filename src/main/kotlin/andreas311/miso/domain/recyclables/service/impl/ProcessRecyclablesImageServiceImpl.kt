package andreas311.miso.domain.recyclables.service.impl

import andreas311.miso.domain.recyclables.enums.RecyclablesType
import andreas311.miso.domain.recyclables.exception.RecyclablesNotFoundException
import andreas311.miso.domain.recyclables.presentation.data.response.DetailRecyclablesResponseDto
import andreas311.miso.domain.recyclables.repository.RecyclablesRepository
import andreas311.miso.domain.recyclables.service.ProcessRecyclablesImageService
import andreas311.miso.global.annotation.ReadOnlyService
import andreas311.miso.global.annotation.RollbackService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.client.RestTemplate
import org.springframework.web.multipart.MultipartFile
import java.util.*

@ReadOnlyService
@RollbackService
class ProcessRecyclablesImageServiceImpl(
    private val restTemplate: RestTemplate,
    private val recyclablesRepository: RecyclablesRepository
) : ProcessRecyclablesImageService {

    @Value("\${secret-url}")
    private val url: String = ""

    override fun execute(multipartFile: MultipartFile): DetailRecyclablesResponseDto {
        val result = restTemplate.postForObject(url, mapOf("image_url" to Base64.getEncoder().encodeToString(multipartFile.bytes)), String::class.java)
            ?.uppercase()?.replace(" ", "_")?.replace("\"", "")?.trim()

        val recyclablesType = result?.let { RecyclablesType.valueOf(it) }

        val recyclables = recyclablesType?.let { recyclablesRepository.findByRecyclablesType(it) }
            ?: throw RecyclablesNotFoundException()

        return DetailRecyclablesResponseDto(recyclables)
    }
}