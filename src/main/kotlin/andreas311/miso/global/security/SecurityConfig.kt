package andreas311.miso.global.security

import andreas311.miso.global.security.filter.JwtExceptionFilter
import andreas311.miso.global.security.filter.JwtRequestFilter
import andreas311.miso.global.security.handler.CustomAccessDeniedHandler
import andreas311.miso.global.security.handler.CustomAuthenticationEntryPointHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtExceptionFilter: JwtExceptionFilter,
    private val jwtRequestFilter: JwtRequestFilter
) {

    @Bean
    fun filterChain(http: HttpSecurity) : SecurityFilterChain {
        return http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeRequests()
            .requestMatchers(RequestMatcher { request ->
                CorsUtils.isPreFlightRequest(request)
            }).permitAll()

            .antMatchers(HttpMethod.POST, "/auth").permitAll()
            .antMatchers(HttpMethod.POST, "/auth/signIn").permitAll()
            .antMatchers(HttpMethod.DELETE, "/auth").permitAll()
            .antMatchers(HttpMethod.PATCH, "/auth").permitAll()

            .antMatchers(HttpMethod.POST, "/email").permitAll()

            .anyRequest().denyAll()
            .and()
            .exceptionHandling()
            .accessDeniedHandler(CustomAccessDeniedHandler())
            .authenticationEntryPoint(CustomAuthenticationEntryPointHandler())

            .and()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(jwtExceptionFilter, JwtRequestFilter::class.java)

            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder(12)
    }
}