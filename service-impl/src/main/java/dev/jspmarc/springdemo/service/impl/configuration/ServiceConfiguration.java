package dev.jspmarc.springdemo.service.impl.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;

@Configuration
public class ServiceConfiguration {
  public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoConverter mongoConverter) {
    return new MongoTemplate(mongoDbFactory, mongoConverter);
  }
}
