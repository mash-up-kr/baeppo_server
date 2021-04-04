package com.baeppo.server.config

import com.baeppo.server.config.properties.S3Properties
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class S3PropertiesTest {

    @Autowired
    lateinit var s3Properties: S3Properties

    @Test
    fun propertiesTest() {
        assertEquals("baeppo-bucket", s3Properties.s3.bucket)
    }

}