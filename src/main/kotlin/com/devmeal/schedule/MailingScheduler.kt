package com.devmeal.schedule

import com.devmeal.extension.toHourMinuteString
import com.devmeal.service.BlogMailingPublisher
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalTime

@Component
class MailingScheduler(
    private val blogMailingPublisher: BlogMailingPublisher
) {
    @Scheduled(cron = "0 0 * * * *")
    fun schedule() {
        val currentTime = LocalTime.now().toHourMinuteString()
        blogMailingPublisher.sendDailyPosting(currentTime)
    }
}