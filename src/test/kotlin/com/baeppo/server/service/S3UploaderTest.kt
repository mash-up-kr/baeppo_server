package com.baeppo.server.service

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockMultipartFile
import java.io.FileInputStream

@SpringBootTest
internal class S3UploaderTest {
    @Autowired
    lateinit var s3Uploader: S3Uploader

    @Test
    fun fileUploadToS3() {
        val imageFile = FileInputStream("src/test/resources/test.jpeg")
        val file1 = MockMultipartFile("images", imageFile)
        val path = s3Uploader.upload(file1)
        assertNotNull(path)
    }
}