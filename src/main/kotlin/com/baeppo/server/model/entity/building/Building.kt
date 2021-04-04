package com.baeppo.server.model.entity.building

import com.baeppo.server.model.entity.review.Review
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Building(
    @Id @GeneratedValue
    var id: Long? = null,
    val latitude: Double,
    val longitude: Double,
    @OneToMany
    var reviewList: MutableList<Review> = mutableListOf()
) : BuildingBaseEntity() {
    fun addReview(review: Review) {

    }
}