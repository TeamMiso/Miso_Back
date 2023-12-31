package andreas311.miso.domain.user.presentation

import andreas311.miso.domain.user.presentation.data.response.PointResponseDto
import andreas311.miso.domain.user.presentation.data.response.UserInfoResponseDto
import andreas311.miso.domain.user.service.GetPointService
import andreas311.miso.domain.user.service.GetUserInfoService
import andreas311.miso.domain.user.service.GivePointService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@RequestController("/user")
class UserController(
    private val getPointService: GetPointService,
    private val getUserInfoService: GetUserInfoService,
    private val givePointService: GivePointService
) {

    @GetMapping
    fun userInfo(): ResponseEntity<UserInfoResponseDto> =
        getUserInfoService.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/point")
    fun point(): ResponseEntity<PointResponseDto> =
        getPointService.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @PostMapping("/give")
    fun givePoint(): ResponseEntity<Void> =
        givePointService.execute()
            .let { ResponseEntity.status(HttpStatus.OK).build() }
}