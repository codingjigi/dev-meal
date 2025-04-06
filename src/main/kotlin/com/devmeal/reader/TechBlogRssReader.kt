package com.devmeal.reader

import com.devmeal.reader.dto.TechBlogPostDto

interface TechBlogRssReader {

    fun parse(): List<TechBlogPostDto>
}