package com.devmeal.service

import com.devmeal.mail.dto.TechBlogGroupDto
import com.devmeal.mail.render.MailTemplateRender
import com.devmeal.mail.sender.MailSender
import com.devmeal.rss.reader.TechBlogRssReader
import org.springframework.stereotype.Component

@Component
class BlogMailingPublisher(
    private val techBlogRssReaders: List<TechBlogRssReader>,
    private val mailTemplateRender: MailTemplateRender,
    private val mailSender: MailSender,
    private val memberService: MemberService,
) {
    fun sendDailyPosting(currentTime: String) {
        val members = memberService.findBySendTime(currentTime)
        val result = techBlogRssReaders
            .flatMap { it.parse() }
            .groupBy { it.source }
            .map { (source, feeds) -> TechBlogGroupDto(source, feeds) }
        val htmlBody = mailTemplateRender.create(result)
        members.getEmails().forEach { mailSender.send(it.email, htmlBody) }
    }
}