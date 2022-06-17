package dev.jspmarc.springdemo.rest.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dev.jspmarc.springdemo")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
