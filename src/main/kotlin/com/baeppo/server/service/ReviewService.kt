package com.baeppo.server.service

import com.baeppo.server.model.dto.review.request.ReviewWriteRequestDto
import com.baeppo.server.model.entity.review.Review
import com.baeppo.server.model.entity.user.User
import com.baeppo.server.model.repository.samplerepositorypackage.ReviewRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val modelMapper: ModelMapper
) {
    @Transactional
    fun createReview(reviewWriteRequestDto: ReviewWriteRequestDto, user: User) {
        val review = modelMapper.map(reviewWriteRequestDto, Review::class.java).apply {
            this.user = User(1)
        }

        reviewRepository.save(review)
    }

}