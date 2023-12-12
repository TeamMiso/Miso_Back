package andreas311.miso.global.util

import andreas311.miso.domain.user.entity.User
import andreas311.miso.domain.user.exception.UserNotFoundException
import andreas311.miso.domain.user.repository.UserRepository
import andreas311.miso.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class UserUtil(
    private val userRepository: UserRepository
) {
    fun currentUser(): User {
        val email = fetchUserEmail()
        return fetchUserByEmail(email)
    }

    private fun fetchUserByEmail(email: String): User =
        userRepository.findByEmail(email) ?: throw UserNotFoundException()

    private fun fetchUserEmail(): String =
        when(val principal = SecurityContextHolder.getContext().authentication.principal) {
            is UserDetails -> (principal as AuthDetails).username
            else -> principal.toString()
        }

}