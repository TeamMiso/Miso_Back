package andreas311.miso.domain.recyclables.service.impl

import andreas311.miso.domain.recyclables.enums.RecyclablesType
import andreas311.miso.domain.recyclables.exception.RecyclablesNotFoundException
import andreas311.miso.domain.recyclables.presentation.data.response.DetailRecyclablesResponseDto
import andreas311.miso.domain.recyclables.presentation.data.response.ListDetailRecyclablesResponseDto
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

    @Value("\${ai.url}")
    private val url: String = ""

    override fun execute(multipartFile: MultipartFile): ListDetailRecyclablesResponseDto {
        val result = restTemplate.postForObject(url, mapOf("image_url" to Base64.getEncoder().encodeToString(multipartFile.bytes)), List::class.java)
            ?.map { it as String }

        val detailRecyclablesList = result?.map {
            it.uppercase().replace(" ", "_").replace("\"", "").trim()
        }?.mapNotNull { recyclablesType ->
            runCatching {
                val type = RecyclablesType.valueOf(recyclablesType)
                recyclablesRepository.findByRecyclablesType(type)
            }.getOrNull()
        } ?: throw RecyclablesNotFoundException()

        val recyclablesList = detailRecyclablesList.map { DetailRecyclablesResponseDto(it) }

        return ListDetailRecyclablesResponseDto(recyclablesList)
    }
}