package com.devmeal.api.controller

import com.devmeal.service.BlogMailingPublisher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/manual")
class ManualMailController(
    private val blogMailingPublisher: BlogMailingPublisher
) {
    @PostMapping("/send")
    fun sendManually(@RequestParam currentTime: String) {
        blogMailingPublisher.sendDailyPosting(currentTime)
    }
}