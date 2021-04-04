package com.baeppo.server.model.repository.samplerepositorypackage

import com.baeppo.server.model.entity.building.Building
import org.springframework.data.jpa.repository.JpaRepository

interface BuildingRepository : JpaRepository<Building, Long> {
    fun findByAddress(address: String): Building?
}