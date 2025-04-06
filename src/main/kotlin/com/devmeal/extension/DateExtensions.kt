package com.devmeal.extension

import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

fun Date.toKoreanString(): String {
    return this.toInstant()
        .atZone(ZoneId.of("Asia/Seoul"))
        .format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"))
}
