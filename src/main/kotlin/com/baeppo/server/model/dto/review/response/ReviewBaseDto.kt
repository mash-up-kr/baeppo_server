package com.baeppo.server.model.dto.review.response

import java.time.LocalDateTime

open class ReviewBaseDto(
    open var title: String? = null,
    var buildingName: String? = null,
    var score: Float? = null,
    var createDate: LocalDateTime? = null,
    var imageList: List<String> = emptyList()
)
