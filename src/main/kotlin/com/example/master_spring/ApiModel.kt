package com.example.master_spring
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

//fun JSON(value: Any) = jacksonObjectMapper().writeValueAsString(value)

data class CreateCityRequest(val name: String)
data class UpdateCityRequest(val name: String)
data class CityDTO(val name: String, val id: Int)

//fun City.DTO() = CityDTO(name=name, id=id.value)

data class CreateUserRequest(val name: String, val age: Int?, val city: String?)

