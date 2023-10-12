package andreas311.miso.domain.item.presentation

import andreas311.miso.domain.item.presentation.data.response.DetailItemResponseDto
import andreas311.miso.domain.item.service.DetailItemService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@RequestController("/item")
class ItemController(
    private val detailItemService: DetailItemService
) {

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<DetailItemResponseDto> =
        detailItemService.execute(id)
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}