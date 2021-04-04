package com.baeppo.server.model.dto.review.response

import com.baeppo.server.model.entity.review.Review
import java.time.LocalDateTime

data class ReviewBaseResponseDto(
    var title: String? = null,
    var buildingName: String? = null,
    var score: Float? = null,
    var createDate: LocalDateTime? = null,
    var imageList: MutableList<ReviewImageResponseDto> = mutableListOf()
) {
    constructor(review: Review) : this() {
        this.title = review.title
        this.createDate = review.createDate
        this.imageList = mutableListOf<ReviewImageResponseDto>().apply {
            this.addAll(review.reviewImageList.map {
                ReviewImageResponseDto(it.path!!)
            })
        }
    }
}

data class ReviewImageResponseDto(
    val path: String
)
