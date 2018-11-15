package com.example.master_spring

//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController{
  @GetMapping("/hello")
  fun sayHello() = "Hello World!"



}