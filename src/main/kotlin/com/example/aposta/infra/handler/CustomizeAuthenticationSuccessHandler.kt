package com.example.aposta.infra.handler

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component

@Component
class CustomizeAuthenticationSuccessHandler : AuthenticationSuccessHandler {
    /**
     * Called when a user has been successfully authenticated.
     * @param request the request which caused the successful authentication
     * @param response the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     * the authentication process.
     */
    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {
        authentication?.let {
            val oidc = authentication.principal as DefaultOidcUser
             val userAttributes = oidc.attributes
            println(userAttributes)
        }
    }


}