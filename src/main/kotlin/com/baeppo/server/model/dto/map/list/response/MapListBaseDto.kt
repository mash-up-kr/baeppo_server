package com.baeppo.server.model.dto.map.list.response

import com.baeppo.server.model.dto.review.response.ReviewBaseResponseDto

open class MapListBaseDto (
    var count: Int? = null,
    var filter: String? = null,
    val reviewResponses: List<ReviewBaseResponseDto> = emptyList()
)