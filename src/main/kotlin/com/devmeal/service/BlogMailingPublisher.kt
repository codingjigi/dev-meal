package com.devmeal.service

import com.devmeal.mail.render.MailTemplateRender
import com.devmeal.mail.sender.MailSender
import com.devmeal.rss.reader.TechBlogRssReader
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class BlogMailingPublisher(
    private val techBlogRssReaders: List<TechBlogRssReader>,
    private val mailTemplateRender: MailTemplateRender,
    private val mailSender: MailSender,
    private val memberService: MemberService,
) {
    fun sendDailyPosting(currentTime: String) {
        val members = memberService.findBySendTime(currentTime)
        val techBlogPosts = techBlogRssReaders.flatMap { it.parse() }
        val htmlBody = mailTemplateRender.create(techBlogPosts)
        members.getEmails().forEach { mailSender.send(it.email, htmlBody) }
    }
}