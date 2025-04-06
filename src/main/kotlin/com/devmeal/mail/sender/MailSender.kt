package com.devmeal.mail.sender

interface MailSender {

    fun send(to: String, htmlBody: String)
}