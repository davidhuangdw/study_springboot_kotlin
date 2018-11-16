package com.example.master_spring.config

import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement


@Configuration
@EnableTransactionManagement
class Exposed{
  @Bean
  fun transactionManager(dataSource: HikariDataSource ) = SpringTransactionManager(dataSource)
      .also{ println("==============${dataSource.connection}")}
}