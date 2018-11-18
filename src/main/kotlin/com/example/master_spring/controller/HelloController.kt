package com.example.master_spring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController{
  @GetMapping("/hello")
  fun sayHello() = "Hello World!"
}