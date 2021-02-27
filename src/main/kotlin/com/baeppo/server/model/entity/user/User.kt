package com.baeppo.server.model.entity.user

import com.baeppo.server.model.entity.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    @Id @GeneratedValue
    var id: Long? = null
) : BaseEntity()