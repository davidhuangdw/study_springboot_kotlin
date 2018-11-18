package com.example.master_spring.controller

import com.example.master_spring.common.toJson
import com.example.master_spring.exception.RequestException
import com.example.master_spring.model.Cities
import com.example.master_spring.model.City
import com.example.master_spring.model.CreateUserRequest
import com.example.master_spring.model.User
import com.example.master_spring.presenter.CollectionPresenter
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@Transactional
class UserController{

  @GetMapping
  fun index(): String {
    val offset = 0
    val limit = 50
    val users = User.all()
    val totalCount = users.count()
    return CollectionPresenter(
        collection = users.limit(limit,offset).toList(),
        offset = offset,
        limit = limit,
        totalCount = totalCount
    ).toJson()
  }

  @GetMapping("/{id}")
  fun get(@PathVariable id: Int) = User.get(id).toJson()

  @PostMapping
  fun create(@RequestBody req: CreateUserRequest):String{
    val user = User.new{
      name = req.name
      if(req.age != null) {
        age = req.age
        if(req.age > 200) throw RequestException(HttpStatus.BAD_REQUEST, "invalid age ${req.age}")
      }
      if(req.city != null)
        City.find{ Cities.name eq req.city}.lastOrNull()?.let{ city = it }
    }
    return user.toJson()
  }
}