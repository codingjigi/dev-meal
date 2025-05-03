package com.devmeal.service

import com.devmeal.api.dto.FormRequestDto
import com.devmeal.domain.Member
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

    fun insert(request: FormRequestDto) {
        val hasEmail = memberRepository.existsByEmail(request.email)
        if(hasEmail) {
            throw RuntimeException("이미 존재하는 이메일입니다.")
        }
        memberRepository.save(Member(request.email, request.preferredSendTime))
    }
}