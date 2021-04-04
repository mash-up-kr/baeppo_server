package com.baeppo.server.service

import com.baeppo.server.model.dto.review.request.ReviewWriteRequestDto
import com.baeppo.server.model.entity.review.Review
import com.baeppo.server.model.entity.review.ReviewImage
import com.baeppo.server.model.entity.user.User
import com.baeppo.server.model.repository.samplerepositorypackage.ReviewImageRepository
import com.baeppo.server.model.repository.samplerepositorypackage.ReviewRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val reviewImageRepository: ReviewImageRepository,
    private val s3Uploader: S3Uploader,
    private val modelMapper: ModelMapper
) {
    @Transactional
    fun createReview(reviewWriteRequestDto: ReviewWriteRequestDto, user: User) {
        val reviewImageList = mutableListOf<ReviewImage>().apply {
            reviewWriteRequestDto.images.forEach { multipartFile ->
                this.add(
                    reviewImageRepository.save(
                        ReviewImage(path = s3Uploader.upload(multipartFile))
                    )
                )
            }
        }

        val review = modelMapper.map(reviewWriteRequestDto, Review::class.java).apply {
            this.user = user
            this.reviewImageList = reviewImageList
        }

        reviewRepository.save(review)
    }

}