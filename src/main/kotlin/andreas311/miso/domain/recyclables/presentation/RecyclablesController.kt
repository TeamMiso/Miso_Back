package andreas311.miso.domain.recyclables.presentation

import andreas311.miso.domain.recyclables.enums.RecyclablesType
import andreas311.miso.domain.recyclables.presentation.data.response.DetailRecyclablesResponseDto
import andreas311.miso.domain.recyclables.presentation.data.response.ListSearchRecyclablesResponseDto
import andreas311.miso.domain.recyclables.presentation.data.response.SearchRecyclablesResponseDto
import andreas311.miso.domain.recyclables.service.DetailRecyclablesService
import andreas311.miso.domain.recyclables.service.ListAllRecyclablesService
import andreas311.miso.domain.recyclables.service.SearchRecyclablesService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestController("/recyclables")
class RecyclablesController(
    private val detailRecyclablesService: DetailRecyclablesService,
    private val searchRecyclablesService: SearchRecyclablesService,
    private val listAllRecyclablesService: ListAllRecyclablesService
) {

    @GetMapping
    fun detail(@RequestParam recyclablesType: RecyclablesType): ResponseEntity<DetailRecyclablesResponseDto> =
        detailRecyclablesService.execute(recyclablesType)
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/search")
    fun search(@RequestParam searchValue: String): ResponseEntity<SearchRecyclablesResponseDto> =
        searchRecyclablesService.execute(searchValue)
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/all")
    fun recyclablesAll(): ResponseEntity<ListSearchRecyclablesResponseDto> =
        listAllRecyclablesService.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}