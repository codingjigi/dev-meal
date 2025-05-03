package com.devmeal.domain

import com.devmeal.converter.YesNoConverter
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "member")
class Member(
    @Column(name = "email", unique = true, nullable = false)
    val email: String,

    @CreatedDate
    @Column(name = "created_at")
    val createdDate: LocalDateTime? = null,

    @LastModifiedDate
    @Column(name = "updated_at")
    val updateDateTime: LocalDateTime? = null,

    @Convert(converter = YesNoConverter::class)
    @Column(name = "unsubscribe_yn", columnDefinition = "VARCHAR(1)")
    var isUnsubscribed: Boolean = false,

    @Column(name = "preferred_send_time", nullable = false)
    val preferredSendTime: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    var id: Long? = null

    constructor(email: String, preferredSendTime: String) : this(
        email = email,
        isUnsubscribed = false,
        preferredSendTime = preferredSendTime,
    )
}
