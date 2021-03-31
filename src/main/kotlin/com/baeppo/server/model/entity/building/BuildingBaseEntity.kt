package com.baeppo.server.model.entity.building

import com.baeppo.server.model.entity.BaseEntity


open class BuildingBaseEntity(
    val name: String? = null,
    val address: String? = null,
    val detailAddress: String? = null,
    val jibunAddress: String? = null,
    val jibunDetailAddress: String? = null
) : BaseEntity()