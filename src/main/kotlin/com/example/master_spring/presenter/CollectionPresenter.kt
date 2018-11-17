package com.example.master_spring.presenter

import com.example.master_spring.common.Jsonable
import com.fasterxml.jackson.databind.ObjectMapper
import org.jetbrains.exposed.sql.Count
import org.jetbrains.exposed.sql.SizedIterable

val DEFAULT_LIMIT = 50

class CollectionPresenter(val collection: List<Jsonable>,
                          val offset: Int = 0,
                          val limit: Int,
                          val totalCount: Int? = null): Jsonable{

  override fun asJson() = mapOf(
      "totalCount" to totalCount,
      "offset" to offset,
      "limit" to limit,
      "count" to collection.size,
      "data" to collection.map{it.asJson()}
  )

}