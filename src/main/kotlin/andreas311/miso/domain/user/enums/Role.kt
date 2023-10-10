package andreas311.miso.domain.user.enums

import org.springframework.security.core.GrantedAuthority

enum class Role(description: String) : GrantedAuthority {
    ROLE_USER("사용자"), ROLE_ADMIN("관리자");

    override fun getAuthority(): String = name
}