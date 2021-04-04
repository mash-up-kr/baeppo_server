package com.baeppo.server.model.repository.samplerepositorypackage

import com.baeppo.server.model.entity.review.ReviewImage
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewImageRepository : JpaRepository<ReviewImage, Long> {
}