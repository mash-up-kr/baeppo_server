package com.baeppo.server.model.dto.review.response

import com.baeppo.server.model.entity.review.Review
import com.fasterxml.jackson.annotation.JsonUnwrapped

data class ReviewDetailResponseDto(
    var contents: String? = null,
    @JsonUnwrapped
    var reviewBaseResponseDto: ReviewBaseResponseDto? = null
) {
    constructor(review: Review) : this() {
        this.contents = review.contents
        this.reviewBaseResponseDto = ReviewBaseResponseDto(review)
    }
}

