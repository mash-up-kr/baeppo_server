package com.baeppo.server.model.repository.samplerepositorypackage

import com.baeppo.server.model.entity.review.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {
}