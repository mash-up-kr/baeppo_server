package com.baeppo.server.controller

import com.baeppo.server.model.entity.user.User
import com.baeppo.server.model.repository.samplerepositorypackage.UserRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.io.FileInputStream

@SpringBootTest
@AutoConfigureMockMvc
class ReviewControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var userRepository: UserRepository

    @BeforeEach
    fun beforeEach() {
        userRepository.save(User())
    }

    @Test
    fun fileUploadTest() {
        val imageFile = FileInputStream("src/test/resources/test.jpeg")
        val file1 = MockMultipartFile("images", imageFile)
        val imageFile2 = FileInputStream("src/test/resources/test.jpeg")
        val file2 = MockMultipartFile("images", imageFile2)


        mockMvc.perform(multipart("/v1/review")
            .file(file1)
            .file(file2)
            .param("title", "test-title"))
            .andExpect(status().isOk)

    }
}