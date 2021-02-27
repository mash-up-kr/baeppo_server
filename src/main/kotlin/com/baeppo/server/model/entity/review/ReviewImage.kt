package com.baeppo.server.model.entity.review

import com.baeppo.server.model.entity.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class ReviewImage(
    @Id @GeneratedValue
    var id: Long? = null,
    var path: String? = null
) : BaseEntity()