package com.devmeal.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FormController {

    @GetMapping("/")
    fun form(): String {
        return "form"
    }
}
