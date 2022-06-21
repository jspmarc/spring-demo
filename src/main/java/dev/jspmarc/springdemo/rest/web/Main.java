package dev.jspmarc.springdemo.rest.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("dev.jspmarc.springdemo")
@EnableMongoRepositories(basePackages = "dev.jspmarc.springdemo.dao")
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
