package com.example.master_spring.common

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

val JSON_MAPPER = jacksonObjectMapper()

interface Jsonable{
  fun asJson(): Map<String, Any?>
}
fun Jsonable.toJson() = JSON_MAPPER.writeValueAsString(asJson())

