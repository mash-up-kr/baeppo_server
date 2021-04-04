package com.baeppo.server.service

import com.baeppo.server.constants.MODEL_MAPPER
import com.baeppo.server.model.dto.review.request.ReviewWriteRequestDto
import com.baeppo.server.model.dto.review.response.ReviewDetailResponseDto
import com.baeppo.server.model.entity.building.Building
import com.baeppo.server.model.entity.review.Review
import com.baeppo.server.model.entity.review.ReviewImage
import com.baeppo.server.model.entity.user.User
import com.baeppo.server.model.repository.samplerepositorypackage.BuildingRepository
import com.baeppo.server.model.repository.samplerepositorypackage.ReviewImageRepository
import com.baeppo.server.model.repository.samplerepositorypackage.ReviewRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val reviewImageRepository: ReviewImageRepository,
    private val buildingRepository: BuildingRepository,
    private val s3Uploader: S3Uploader
) {
    @Transactional
    fun createReview(reviewWriteRequestDto: ReviewWriteRequestDto, user: User) {
        val reviewImageList = reviewWriteRequestDto.images.map { multipartFile ->
            val filePath = s3Uploader.upload(multipartFile)
            reviewImageRepository.save(ReviewImage(path = filePath))
        }

        val review = MODEL_MAPPER.map(reviewWriteRequestDto, Review::class.java).apply {
            this.reviewImageList = reviewImageList
        }

        val building = buildingRepository.findByAddress(reviewWriteRequestDto.address) ?: buildingRepository.save(
            Building(latitude = 1.0, longitude = 1.0)
        )
        building.addReview(review)

        reviewRepository.save(review)
    }

    fun getReview(reviewId: Long): ReviewDetailResponseDto {
        val review = reviewRepository.findById(reviewId).orElseThrow()
        return ReviewDetailResponseDto(review)
    }
}