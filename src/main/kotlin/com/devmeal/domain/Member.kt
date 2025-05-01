package com.devmeal.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "member")
class Member(
    val email: String,

    @CreatedDate
    val createdDate: LocalDateTime? = null,

    @LastModifiedDate
    val updateDateTime: LocalDateTime? = null,

    var isUnsubscribed: Boolean = false,

    val preferredSendTime: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    constructor(email: String, preferredSendTime: String) : this(
        email = email,
        isUnsubscribed = false,
        preferredSendTime = preferredSendTime,
    )
}
