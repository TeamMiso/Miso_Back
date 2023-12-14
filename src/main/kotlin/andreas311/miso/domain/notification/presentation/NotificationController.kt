package andreas311.miso.domain.notification.presentation

import andreas311.miso.domain.notification.presentation.data.response.DetailNotificationResponseDto
import andreas311.miso.domain.notification.service.DetailNotificationService
import andreas311.miso.domain.notification.service.SaveDeviceTokenService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@RequestController("/notification")
class NotificationController(
    private val saveDeviceTokenService: SaveDeviceTokenService,
    private val detailNotificationService: DetailNotificationService
) {

    @PostMapping("/save/{deviceToken}")
    fun save(@PathVariable deviceToken: String): ResponseEntity<Void> =
        saveDeviceTokenService.execute(deviceToken)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping("/detail")
    fun detail(@PathVariable id: Long): ResponseEntity<DetailNotificationResponseDto> =
        detailNotificationService.execute(id)
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}
