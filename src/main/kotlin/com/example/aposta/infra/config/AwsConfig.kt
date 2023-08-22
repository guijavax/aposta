package com.example.aposta.infra.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsConfig {

    @Value(value = "\${aws.region}")
    lateinit var regionAws: String

    @Bean
    fun getIdentityProvider(): AWSCognitoIdentityProvider =
        AWSCognitoIdentityProviderClientBuilder
            .standard().apply {
                credentials = AWSStaticCredentialsProvider(EnvironmentVariableCredentialsProvider().credentials)
                region = regionAws
            }.build()

}