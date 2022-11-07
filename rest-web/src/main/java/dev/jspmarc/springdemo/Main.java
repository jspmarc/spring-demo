package dev.jspmarc.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "dev.jspmarc.springdemo.dao")
@EnableSwagger2
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
