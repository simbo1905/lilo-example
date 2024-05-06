package demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class HelloController {
  @QueryMapping
  public String hello2(){
    log.info("HelloController.hello2() called");
    return "Hello from server 2";
  }
}
