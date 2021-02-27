package com.baeppo.server.model.entity.review

import com.baeppo.server.model.entity.BaseEntity
import com.baeppo.server.model.entity.user.User
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Bookmark(
    @Id @GeneratedValue
    var id: Long? = null,
    @ManyToOne
    var user: User
) : BaseEntity()
