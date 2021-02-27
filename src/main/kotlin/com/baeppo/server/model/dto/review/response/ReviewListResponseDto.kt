package com.baeppo.server.model.dto.review.response

data class ReviewListResponseDto(
    val reviewBasicList: List<ReviewBaseDto> = emptyList()
)
