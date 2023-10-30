package andreas311.miso.domain.user.presentation

import andreas311.miso.domain.user.presentation.data.response.PointResponseDto
import andreas311.miso.domain.user.presentation.data.response.UserInfoResponseDto
import andreas311.miso.domain.user.service.GetPointService
import andreas311.miso.domain.user.service.GetUserInfoService
import andreas311.miso.global.annotation.RequestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@RequestController("/user")
class UserController(
    private val getPointService: GetPointService,
    private val getUserInfoService: GetUserInfoService
) {

    @GetMapping
    fun userInfo(): ResponseEntity<UserInfoResponseDto> =
        getUserInfoService.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/point")
    fun point(): ResponseEntity<PointResponseDto> =
        getPointService.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

}