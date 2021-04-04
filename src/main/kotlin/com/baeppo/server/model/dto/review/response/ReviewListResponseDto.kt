package com.baeppo.server.model.dto.review.response

data class ReviewListResponseDto(
    val reviewBasicListResponse: List<ReviewBaseResponseDto> = emptyList()
)
