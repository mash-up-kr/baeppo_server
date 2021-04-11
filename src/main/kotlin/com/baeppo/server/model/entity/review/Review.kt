package com.baeppo.server.model.entity.review

import com.baeppo.server.model.entity.BaseEntity
import com.baeppo.server.model.entity.user.User
import javax.persistence.*

@Entity
class Review(
    @Id @GeneratedValue
    var id: Long? = null,
    @ManyToOne
    var user: User? = null,
    @OneToMany(cascade = [CascadeType.PERSIST, CascadeType.REMOVE])
    var reviewImageList: List<ReviewImage> = emptyList(),
    val title: String? = null,
    val contents: String? = null,
    val distance: Int? = null,
    val owner: Int? = null,
    val safety: Int? = null,
    val clean: Int? = null
) : BaseEntity()