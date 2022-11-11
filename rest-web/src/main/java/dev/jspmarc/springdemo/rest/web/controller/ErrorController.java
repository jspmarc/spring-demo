package dev.jspmarc.springdemo.rest.web.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {

  @ExceptionHandler(Exception.class)
  public String error() {
    return "broke";
  }
}
