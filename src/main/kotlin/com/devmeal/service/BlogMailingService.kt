package com.devmeal.service

import com.devmeal.mail.MailSender
import com.devmeal.mail.MailTemplateRender
import com.devmeal.reader.TechBlogRssReader
import org.springframework.stereotype.Service

@Service
class BlogMailingService(
    private val techBlogRssReaders: List<TechBlogRssReader>,
    private val mailTemplateRender: MailTemplateRender,
    private val mailSender: MailSender
) {
    fun sendDailyPosting() {
        val techBlogPosts = techBlogRssReaders.flatMap { it.parse() }
        val htmlBody = mailTemplateRender.create(techBlogPosts)
        mailSender.send("", htmlBody)
    }
}