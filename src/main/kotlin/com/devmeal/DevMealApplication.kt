package com.devmeal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DevMealApplication

fun main(args: Array<String>) {
    runApplication<DevMealApplication>(*args)
}
