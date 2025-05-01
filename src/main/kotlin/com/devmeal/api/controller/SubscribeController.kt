package com.devmeal.api.controller

import com.devmeal.api.dto.FormRequestDto
import com.devmeal.service.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class SubscribeController(
    private val memberService: MemberService
) {

    @PostMapping("/subscribe")
    fun subscribe(@RequestBody form: FormRequestDto) {
        memberService.insert(form)
    }
}