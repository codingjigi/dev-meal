package com.devmeal.mail.sender

import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
internal class DefaultMailSender(
    private val javaMailSender: JavaMailSender
) : MailSender {
    @Async
    override fun send(to: String, htmlBody: String) {
        val message = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true, "UTF-8")

        helper.setFrom("codingjigi@gmail.com")
        helper.setTo(to)
        helper.setSubject("📰 기술 블로그 📖 | 오늘의 최신 글을 확인하세요! 🔥")
        helper.setText(htmlBody, true)

        javaMailSender.send(message)
    }
}