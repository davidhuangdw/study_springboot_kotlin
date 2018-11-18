package com.example.master_spring.controller

import com.example.master_spring.common.toJson
import com.example.master_spring.model.City
import com.example.master_spring.model.CreateCityRequest
import com.example.master_spring.model.UpdateCityRequest
import com.example.master_spring.presenter.CollectionPresenter
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cities")
@Transactional
class CityController{
  @GetMapping
  fun index(): String{
    val offset = 0
    val limit = 50
    val cities = City.all()
    val totalCount = cities.count()
    return CollectionPresenter(
        collection = cities.limit(limit,offset).toList(),
        offset = offset,
        limit = limit,
        totalCount = totalCount
    ).toJson()
  }

  @PostMapping
  fun create(@RequestBody req: CreateCityRequest) = City.new{name = req.name}.toJson()

  @GetMapping("/{id}")
  fun get(@PathVariable id: Int) = City.get(id).toJson()

  @PutMapping("/{id}")
  fun update(@PathVariable id: Int, @RequestBody req: UpdateCityRequest): String{
    val city = City.get(id)
    city.name = req.name
    return city.toJson()
  }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Int): String{
    val city = City.get(id)
    city.delete()
    return "ok"
  }
}