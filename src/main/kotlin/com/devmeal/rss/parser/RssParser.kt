package com.devmeal.rss.parser

import com.devmeal.rss.parser.dto.RssDto

interface RssParser {
    fun parse(url: String): List<RssDto>
}