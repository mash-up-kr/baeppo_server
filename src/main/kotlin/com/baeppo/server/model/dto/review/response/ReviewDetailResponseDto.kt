package com.baeppo.server.model.dto.review.response

data class ReviewDetailResponseDto(
    override var title: String? = null,
    var content: String? = null
) : ReviewBaseDto()
