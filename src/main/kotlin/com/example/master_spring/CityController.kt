package com.example.master_spring

import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cities")
@Transactional
class CityController{
  @GetMapping
  fun index() = JSON(City.all().map(City::DTO))

  @PostMapping
  fun create(@RequestBody req: CreateCityRequest) = JSON(City.new{name = req.name}.DTO())

  @GetMapping("/{id}")
  fun get(@PathVariable id: Int) = JSON(City.get(id).DTO())

  @PutMapping("/{id}")
  fun update(@PathVariable id: Int, @RequestBody req: UpdateCityRequest): String{
    val city = City.get(id)
    city.name = req.name
    return JSON(city.DTO())
  }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Int): String{
    val city = City.get(id)
    city.delete()
    return "ok"
  }
}