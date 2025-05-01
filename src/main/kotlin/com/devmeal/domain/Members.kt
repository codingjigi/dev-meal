package com.devmeal.domain

data class Members(
    private val members: List<MemberDto>
) {
    fun getEmails(): List<MemberDto> = members
}

data class MemberDto(
    val email: String
)