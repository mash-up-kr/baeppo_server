package com.baeppo.server.model.entity.sampleentitypackage

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class SampleEntity(
    @Id @GeneratedValue
    val id: Long? = null
)