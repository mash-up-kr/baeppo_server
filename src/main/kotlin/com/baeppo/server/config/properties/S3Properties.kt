package com.baeppo.server.config.properties

import com.baeppo.server.config.YamlPropertySourceFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ConfigurationProperties(prefix ="baeppo.cloud.aws")
@PropertySource(value = ["classpath:aws.yml"], factory = YamlPropertySourceFactory::class)
class S3Properties(
    var credentials: Credential = Credential(),
    var s3: S3 = S3(),
    var region: Region = Region(),
    var stack: Stack = Stack()
)

data class Credential(
    var accessKey: String? = null,
    var secretKey: String? = null
)

data class S3(
    var bucket: String? = null
)

data class Region(
    var static: String? = null
)

data class Stack(
    var auto: Boolean? = null
)
