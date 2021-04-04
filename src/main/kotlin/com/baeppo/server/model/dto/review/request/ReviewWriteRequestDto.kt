package com.baeppo.server.model.dto.review.request

import org.springframework.web.multipart.MultipartFile

data class ReviewWriteRequestDto(
    var address: String = "",
    var detailAddress: String = "",
    var title: String = "",
    var content: String? = null,
    var distance: Int? = null,
    var owner: Int? = null,
    var safety: Int? = null,
    var clean: Int? = null,
    var images: List<MultipartFile> = emptyList()
)
