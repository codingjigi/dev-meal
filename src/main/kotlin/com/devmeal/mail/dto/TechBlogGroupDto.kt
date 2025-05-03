package com.devmeal.mail.dto

import com.devmeal.rss.reader.dto.TechBlogPostDto

data class TechBlogGroupDto(
    val source: String,
    val posts: List<TechBlogPostDto>
)