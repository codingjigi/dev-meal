package com.devmeal.parser

import com.devmeal.parser.dto.RssDto

interface RssParser {
    fun parse(url: String): List<RssDto>
}