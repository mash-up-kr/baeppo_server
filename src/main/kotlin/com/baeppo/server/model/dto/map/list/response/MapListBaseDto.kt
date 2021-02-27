package com.baeppo.server.model.dto.map.list.response

import com.baeppo.server.model.dto.review.response.ReviewBaseDto

open class MapListBaseDto (
    var count: Int? = null,
    var filter: String? = null,
    val reviews: List<ReviewBaseDto> = emptyList()
)