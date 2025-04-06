package com.devmeal.rss.reader

import com.devmeal.rss.reader.dto.TechBlogPostDto

interface TechBlogRssReader {

    fun parse(): List<TechBlogPostDto>
}