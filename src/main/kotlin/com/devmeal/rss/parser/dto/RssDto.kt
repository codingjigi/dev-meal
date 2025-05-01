package com.devmeal.rss.parser.dto

import java.util.Date

data class RssDto(
    val title: String,
    val link: String,
    val author: String,
    val publishedDate: Date
)