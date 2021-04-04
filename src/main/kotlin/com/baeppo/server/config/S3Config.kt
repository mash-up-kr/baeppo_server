package com.baeppo.server.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.baeppo.server.config.properties.S3Properties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class S3Config(
    private val s3Properties: S3Properties
) {

    @Bean
    fun s3Client(): AmazonS3 {
        val credentials = BasicAWSCredentials(s3Properties.credentials.accessKey, s3Properties.credentials.secretKey)
        return AmazonS3ClientBuilder.standard()
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .withRegion(s3Properties.region.static)
            .build()
    }

}