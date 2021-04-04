package com.baeppo.server.model.dto.review.response

import com.baeppo.server.model.entity.review.Review
import com.fasterxml.jackson.annotation.JsonUnwrapped

data class ReviewDetailResponseDto(
    var content: String? = null,
    @JsonUnwrapped
    var reviewBaseResponseDto: ReviewBaseResponseDto? = null
) {
    constructor(content: String?, review: Review) : this() {
        this.content = review.content
        this.reviewBaseResponseDto = ReviewBaseResponseDto(review)
    }
}

