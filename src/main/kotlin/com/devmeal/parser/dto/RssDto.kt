package com.devmeal.parser.dto

import java.util.*

data class RssDto(
    val title: String,
    val link: String,
    val author: String,
    val publishedDate: Date
)