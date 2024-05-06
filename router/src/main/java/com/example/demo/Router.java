package com.example.demo;

import io.fria.lilo.GraphQLRequest;
import io.fria.lilo.Lilo;
import io.fria.lilo.RemoteSchemaSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@Controller
public class Router {
  private final Lilo lilo;

  public Router() {
    this.lilo = Lilo.builder()
        .addSource(RemoteSchemaSource.create("server1", "http://localhost:8081/graphql"))
        .addSource(RemoteSchemaSource.create("server2", "http://localhost:8082/graphql"))
        .build();
    log.info("Router created");
  }

  @ResponseBody
  @PostMapping("/graphql")
  public Map<String,Object> stitchedSchema(@RequestBody GraphQLRequest input){
    log.info("Router.stitchedSchema() called");
    return this.lilo.stitch(input.toExecutionInput()).toSpecification();
  }
}
