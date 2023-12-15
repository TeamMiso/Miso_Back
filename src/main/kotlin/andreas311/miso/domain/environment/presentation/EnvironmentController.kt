package andreas311.miso.domain.environment.presentation

import andreas311.miso.domain.environment.presentation.data.response.EnvironmentInfoResponseDto
import andreas311.miso.domain.environment.service.GetTodayEnvironmentInfoService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@RequestController("/environment")
class EnvironmentController(
    private val getTodayEnvironmentInfoService: GetTodayEnvironmentInfoService
) {

   @GetMapping
   fun today(): ResponseEntity<EnvironmentInfoResponseDto> =
       getTodayEnvironmentInfoService.execute()
           .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}