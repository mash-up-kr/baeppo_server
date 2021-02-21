package com.baeppo.server.model.dto.review.request

data class ReviewWriteRequestDto(
    val address: String,
    val detailAddress: String,
    val schoolDistanceScore: Int,
    val hoseOwnerScore: Int,
    val title: String,
    val contents: String
)
