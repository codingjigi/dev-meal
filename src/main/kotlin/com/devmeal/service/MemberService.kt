package com.devmeal.service

import com.devmeal.domain.Member
import com.devmeal.api.dto.FormRequestDto
import com.devmeal.domain.MemberDto
import com.devmeal.domain.Members
import com.devmeal.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    fun findBySendTime(preferredSendTime: String): Members {
        return Members(
            memberRepository.findByPreferredSendTime(preferredSendTime).map { MemberDto(it.email) }
        )
    }

    fun insert(form: FormRequestDto) {
        memberRepository.save(Member(form.email, form.preferredSendTime))
    }
}