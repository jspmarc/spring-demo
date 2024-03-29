package dev.jspmarc.springdemo.rest.web.controller;

import dev.jspmarc.springdemo.entity.constant.ApiPath;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.BASE_TEST_PATH)
public class TestController {

  @GetMapping()
  @ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
  public String test() {
    return "Ich bin teekanne";
  }
}
