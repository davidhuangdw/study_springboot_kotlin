package com.example.master_spring

import com.example.master_spring.common.toJson
import com.example.master_spring.presenter.CollectionPresenter
import org.jetbrains.exposed.sql.select
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

  @PostMapping
  fun create(@RequestBody req: CreateUserRequest):String{
    val user = User.new{
      name = req.name
      if(req.age != null) age = req.age
      if(req.city != null)
        City.find{Cities.name eq req.city}.lastOrNull()?.let{ city = it }
    }
    return user.toJson()
  }
}