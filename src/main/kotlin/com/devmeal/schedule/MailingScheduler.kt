package com.devmeal.schedule

import com.devmeal.service.BlogMailingService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class MailingScheduler(
    private val blogMailingService: BlogMailingService
) {
    fun schedule() {
        blogMailingService.sendDailyPosting()
    }
}