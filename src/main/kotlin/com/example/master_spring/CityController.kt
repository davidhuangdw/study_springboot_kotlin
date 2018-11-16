package com.example.master_spring

import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/cities")
@Transactional
class CityController{
  @GetMapping
  fun index() = City.all().joinToString(prefix = "[", postfix = "]", separator = ",") { "{id: ${it.id}, name: ${it.name}}" }
}