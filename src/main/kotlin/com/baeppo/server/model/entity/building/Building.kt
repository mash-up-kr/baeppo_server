package com.baeppo.server.model.entity.building

import javax.persistence.Entity

@Entity
class Building (
    val latitude: Double,
    val longitude: Double
) : BuildingBaseEntity()