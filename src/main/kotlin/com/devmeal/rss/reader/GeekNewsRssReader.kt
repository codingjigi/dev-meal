package com.devmeal.rss.reader

import com.devmeal.extension.toKoreanString
import com.devmeal.rss.parser.RssParser
import com.devmeal.rss.reader.dto.TechBlogPostDto
import org.springframework.stereotype.Component

@Component
class GeekNewsRssReader (
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
        private const val URL = "https://feeds.feedburner.com/geeknews-feed"
        private const val SOURCE = "긱뉴스"
    }
}
