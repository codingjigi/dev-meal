package com.devmeal.extension

import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

fun Date.toKoreanString(): String {
    return this.toInstant()
        .atZone(ZoneId.of("Asia/Seoul"))
        .format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"))
}

fun LocalTime.toHourMinuteString(): String {
    return this.withSecond(0).withNano(0).toString().substring(0, 5)
}

fun Date.isToday(): Boolean {
    val today = Calendar.getInstance()
    val target = Calendar.getInstance().apply { time = this@isToday }

    return today.get(Calendar.YEAR) == target.get(Calendar.YEAR) &&
        today.get(Calendar.DAY_OF_YEAR) == target.get(Calendar.DAY_OF_YEAR)
}