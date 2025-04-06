package com.devmeal.mail

interface MailSender {

    fun send(to: String, htmlBody: String)
}