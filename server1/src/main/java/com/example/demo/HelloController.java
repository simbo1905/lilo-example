package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class HelloController {
  @QueryMapping
  public String hello1(){
    log.info("HelloController.hello1() called");
    return "Hello from server 1!";
  }
}
