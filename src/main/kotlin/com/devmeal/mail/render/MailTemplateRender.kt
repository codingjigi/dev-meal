package com.devmeal.mail.render

import com.devmeal.rss.reader.dto.TechBlogPostDto
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine

@Component
class MailTemplateRender(
    private val templateEngine: SpringTemplateEngine
) {
    fun create(posts: List<TechBlogPostDto>): String {
        val context = Context().apply {
            setVariable("posts", posts)
        }
        return templateEngine.process("techDigest", context)
    }
}