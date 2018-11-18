package com.example.master_spring.model

import com.example.master_spring.common.Jsonable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object Users: IntIdTable("users"){
  val name = varchar("name", 50)
  val city = reference("city_id", Cities).nullable()
  val age = integer("age")
}

object Cities: IntIdTable("cities"){
  val name = varchar("name", 50)
}

class User(id: EntityID<Int>): IntEntity(id), Jsonable{
  companion object: IntEntityClass<User>(Users)

  var name by Users.name
  var age by Users.age
  var city by City optionalReferencedOn Users.city
  override fun asJson() = mapOf(
      "id" to id.value,
      "name" to name,
      "age" to age,
      "city" to city?.asJson()
  )
}

class City(id: EntityID<Int>): IntEntity(id), Jsonable{
  companion object:  IntEntityClass<City>(Cities)

  var name by Cities.name
  val users by User optionalReferrersOn Users.city
  override fun asJson() = mapOf("id" to id.value, "name" to name)
}

