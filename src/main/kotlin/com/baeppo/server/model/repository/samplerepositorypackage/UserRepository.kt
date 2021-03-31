package com.baeppo.server.model.repository.samplerepositorypackage

import com.baeppo.server.model.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}