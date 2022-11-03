package dev.jspmarc.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "dev.jspmarc.springdemo.dao")
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
