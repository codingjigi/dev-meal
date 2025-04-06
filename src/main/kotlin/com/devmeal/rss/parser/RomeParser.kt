package com.devmeal.rss.parser

import com.devmeal.rss.parser.dto.RssDto
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.springframework.stereotype.Component
import java.net.URI

@Component
internal class RomeParser : RssParser {
    override fun parse(url: String): List<RssDto> =
        SyndFeedInput().build(XmlReader((URI.create(url).toURL()))).entries.map {
            RssDto(
                title = it.title,
                link = it.link,
                author = it.author,
                publishedDate = it.publishedDate
            )
        }
}