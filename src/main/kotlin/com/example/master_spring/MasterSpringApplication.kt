package com.example.master_spring

import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@SpringBootApplication
class MasterSpringApplication

fun main(args: Array<String>) {
  runApplication<MasterSpringApplication>(*args)
}
