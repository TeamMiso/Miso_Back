package andreas311.miso.domain.user.service.impl

import andreas311.miso.domain.user.service.GivePointService
import andreas311.miso.global.annotation.RollbackService
import andreas311.miso.global.util.UserUtil

@RollbackService
class GivePointServiceImpl(
    private val userUtil: UserUtil
) : GivePointService {

    override fun execute() {

        val user = userUtil.currentUser()

        user.addPoint(100)
    }
}