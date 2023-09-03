package com.example.aposta.infra.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsConfig {

    @Value(value = "\${aws.region}")
    lateinit var regionAws: String

    var credentialsAws : AWSStaticCredentialsProvider = AWSStaticCredentialsProvider(EnvironmentVariableCredentialsProvider().credentials)

    @Bean
    fun getIdentityProvider(): AWSCognitoIdentityProvider =
        AWSCognitoIdentityProviderClientBuilder
            .standard().apply {
                credentials = credentialsAws
                region = regionAws
            }.build()

    @Bean
    fun s3Config()  =
        AmazonS3ClientBuilder.standard().apply {
            credentials = credentialsAws
            region = regionAws
        }.build()

}