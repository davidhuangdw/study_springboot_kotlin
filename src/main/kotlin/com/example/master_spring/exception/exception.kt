package com.example.master_spring.exception

import org.springframework.http.HttpStatus

class RequestException(val status: HttpStatus, message: String?): RuntimeException(message)
