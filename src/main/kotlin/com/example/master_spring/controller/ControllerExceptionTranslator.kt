package com.example.master_spring.controller

import com.example.master_spring.exception.RequestException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jetbrains.exposed.exceptions.EntityNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.logging.Logger

@ControllerAdvice
class ControllerExceptionTranslator{

  private val logger = LoggerFactory.getLogger(javaClass.name)
  private val TRACE_LIMIT = 0..20

  private fun errorJson(err: String?) = jacksonObjectMapper().writeValueAsString(mapOf("error" to err))
  private fun traceInfo(ex: Exception) = ex.stackTrace.slice(TRACE_LIMIT)
      .joinToString("\n", "\n", "\n...\n")

  @ExceptionHandler(RequestException::class)
  fun handleRequestException(ex: RequestException) = ResponseEntity(errorJson(ex.message), ex.status)
      .also{
        logger.error(ex.message)
        logger.error(traceInfo(ex))
      }

  @ExceptionHandler(EntityNotFoundException::class)
  fun handleEntityNotFound(ex: EntityNotFoundException) = handleRequestException(
      RequestException(HttpStatus.NOT_FOUND, ex.message)
  )
}