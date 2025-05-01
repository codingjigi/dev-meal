package com.devmeal.repository

import com.devmeal.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByPreferredSendTime(time: String): List<Member>
}