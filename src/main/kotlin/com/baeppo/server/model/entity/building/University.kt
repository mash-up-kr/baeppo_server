package com.baeppo.server.model.entity.building

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class University(
    @Id @GeneratedValue
    var id: Long? = null
) : BuildingBaseEntity()