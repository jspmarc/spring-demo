package dev.jspmarc.springdemo.libraries.configuration;

import com.mongodb.MongoClientOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class MongoConfiguration {
    @Bean
    @Primary
    public MongoClientOptions primaryMongoClientOptions() {
        return MongoClientOptions.builder().build();
    }
}
