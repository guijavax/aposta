package com.example.aposta

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity


@SpringBootApplication
class ApostaApplication
fun main(args: Array<String>) {
	runApplication<ApostaApplication>(*args)
}
