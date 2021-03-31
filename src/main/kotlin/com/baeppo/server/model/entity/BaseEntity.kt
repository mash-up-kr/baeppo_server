package com.baeppo.server.model.entity

import java.time.LocalDateTime

open class BaseEntity(
    var createDate: LocalDateTime? = null,
    var deleteDate: LocalDateTime? = null,
    var updateDate: LocalDateTime? = null
)