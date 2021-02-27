package com.baeppo.server.model.dto.review.request

data class ReviewWriteRequestDto(
    val title: String,
    val content: String,
    val distance: Int,
    val owner: Int,
    val safety: Int,
    val clean: Int
)
