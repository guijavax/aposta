package com.example.aposta.infra.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import java.util.stream.Collectors
import org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher


@Configuration
@EnableWebSecurity
class SecurityConfig  {

    @Autowired
    lateinit var customizeAuthenticationSuccessHandler: AuthenticationSuccessHandler

    @Bean
    fun securityFilterChain(http: HttpSecurity) =
        http
            .authorizeHttpRequests { authorizeHttpRequests ->
                authorizeHttpRequests
                    .requestMatchers(antMatcher("/")).permitAll()
                    .requestMatchers(antMatcher("/cliente/**")).hasRole("USER")
                    .requestMatchers(antMatcher("/clienteTrial/**")).hasRole("TRIAL")
                    .requestMatchers(antMatcher("/**")).hasRole("ADMIN")
                    .anyRequest().authenticated()

            }.oauth2Login{oauth->
                oauth.redirectionEndpoint{endpoint ->
                    endpoint.baseUri("/login/oauth2/code/cognito")

                }.userInfoEndpoint {
                    userInfo -> userInfo.userAuthoritiesMapper(useAuthoritiesMapper())
                }.successHandler(customizeAuthenticationSuccessHandler)

            }.logout{ it.logoutSuccessUrl("/login")}.build()


    @Bean
    fun useAuthoritiesMapper() : GrantedAuthoritiesMapper {
        return GrantedAuthoritiesMapper {authorities ->
            val oidcUserAuthority = ArrayList<Any>(authorities)[0] as OidcUserAuthority

               (oidcUserAuthority.getAttributes().get("cognito:groups") as Collection<GrantedAuthority>?)?.let {
                   it.stream().map { role -> SimpleGrantedAuthority("ROLE_$role") }.collect(Collectors.toSet())
               }
        }
    }
}