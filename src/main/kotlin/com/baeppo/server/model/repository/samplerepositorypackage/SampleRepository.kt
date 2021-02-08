package com.baeppo.server.model.repository.samplerepositorypackage

import com.baeppo.server.model.entity.sampleentitypackage.SampleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SampleRepository : JpaRepository<SampleEntity, Long> {
}