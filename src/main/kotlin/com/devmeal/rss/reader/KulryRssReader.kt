package com.devmeal.rss.reader

import com.devmeal.extension.toKoreanString
import com.devmeal.rss.parser.RssParser
import com.devmeal.rss.reader.dto.TechBlogPostDto

class KulryRssReader(
    private val parser: RssParser
) : TechBlogRssReader {
    override fun parse(): List<TechBlogPostDto> {
        val results = parser.parse(URL)
        return results.map {
            TechBlogPostDto(
                title = it.title,
                link = it.link,
                author = it.author,
                publishedDate = it.publishedDate.toKoreanString(),
                source = SOURCE
            )
        }
    }

    companion object {
        private const val URL = "https://helloworld.kurly.com/feed.xml"
        private const val SOURCE = "컬리"
    }
}