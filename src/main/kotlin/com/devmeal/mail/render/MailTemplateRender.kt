package com.devmeal.mail.render

import com.devmeal.mail.dto.TechBlogGroupDto
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine

@Component
class MailTemplateRender(
    private val templateEngine: SpringTemplateEngine
) {
    fun create(posts: List<TechBlogGroupDto>): String {
        val context = Context().apply {
            setVariable("posts", posts)
        }
        return templateEngine.process("techDigest", context)
    }
}