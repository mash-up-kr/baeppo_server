package com.baeppo.server.model.entity.building

import com.baeppo.server.model.entity.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
open class BuildingBaseEntity(
    @Id @GeneratedValue
    var id: Long? = null,
    val name: String? = null,
    val address: String? = null,
    val detailAddress: String? = null,
    val jibunAddress: String? = null,
    val jibunDetailAddress: String? = null
) : BaseEntity()