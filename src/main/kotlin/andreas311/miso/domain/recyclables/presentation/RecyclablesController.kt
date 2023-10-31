package andreas311.miso.domain.recyclables.presentation

import andreas311.miso.domain.recyclables.enums.RecyclablesType
import andreas311.miso.domain.recyclables.presentation.data.response.DetailRecyclablesResponseDto
import andreas311.miso.domain.recyclables.service.DetailRecyclablesService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestController("/recyclables")
class RecyclablesController(
    private val detailRecyclablesService: DetailRecyclablesService
) {

    @GetMapping
    fun execute(@RequestParam recyclablesType: RecyclablesType): ResponseEntity<DetailRecyclablesResponseDto> =
        detailRecyclablesService.execute(recyclablesType)
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}