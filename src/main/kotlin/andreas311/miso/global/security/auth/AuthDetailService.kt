package andreas311.miso.global.security.auth

import andreas311.miso.domain.user.exception.UserNotFoundException
import andreas311.miso.domain.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepository.findByEmail(username) ?: throw UserNotFoundException()

        return AuthDetails(user)
    }
}