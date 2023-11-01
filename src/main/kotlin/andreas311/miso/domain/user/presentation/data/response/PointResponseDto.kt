package andreas311.miso.domain.user.presentation.data.response

import andreas311.miso.domain.user.entity.User

data class PointResponseDto(
    val point: Int
) {
    constructor(user: User) : this(
        point = user.point
    )
}
