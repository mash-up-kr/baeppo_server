package com.baeppo.server.controller

import com.baeppo.server.model.dto.review.request.ReviewWriteRequestDto
import com.baeppo.server.model.dto.review.response.ReviewBaseResponseDto
import com.baeppo.server.model.dto.review.response.ReviewDetailResponseDto
import com.baeppo.server.model.dto.review.response.ReviewListResponseDto
import com.baeppo.server.model.entity.user.User
import com.baeppo.server.service.ReviewService
import com.baeppo.server.util.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping(
    value = ["/v1/review"], consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE]
)
class ReviewController(
    private val reviewService: ReviewService
) {

    companion object : Logger

    @PostMapping
    fun review(reviewWriteRequestDto: ReviewWriteRequestDto): ResponseEntity<Unit> {
        reviewService.createReview(reviewWriteRequestDto, User(1))
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/{reviewId}")
    fun getReview(@PathVariable reviewId: Long): ReviewDetailResponseDto {
        return reviewService.getReview(reviewId)
    }

    @GetMapping("/interest")
    fun getReviewByInterest(): ReviewListResponseDto {
        val list = mutableListOf<ReviewBaseResponseDto>().apply {
            repeat(3) {
                this.add(ReviewBaseResponseDto("title", "buildingName-interest", 2.5F, LocalDateTime.now()).apply {
                    imageList = mutableListOf<String>().apply {
                        this.add("mock-image-path")
                    }
                })
            }
        }
        return ReviewListResponseDto(list)
    }

    @GetMapping("/building/{buildingId}")
    fun getReviewByBuilding(@PathVariable buildingId: Long): ResponseEntity<ReviewListResponseDto> {
        val list = mutableListOf<ReviewBaseResponseDto>().apply {
            repeat(3) {
                this.add(ReviewBaseResponseDto("title", "buildingName-building", 2.5F, LocalDateTime.now()).apply {
                    imageList = mutableListOf<String>().apply {
                        this.add("mock-image-path")
                    }
                })
            }
        }
        val response = ReviewListResponseDto(list)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/my")
    fun getMyReview(): ResponseEntity<ReviewListResponseDto> {
        val list = mutableListOf<ReviewBaseResponseDto>().apply {
            repeat(3) {
                this.add(ReviewBaseResponseDto("title", "buildingName-my", 2.5F, LocalDateTime.now()).apply {
                    imageList = mutableListOf<String>().apply {
                        this.add("mock-image-path")
                    }
                })
            }
        }
        val response = ReviewListResponseDto(list)
        return ResponseEntity(response, HttpStatus.OK)
    }

}