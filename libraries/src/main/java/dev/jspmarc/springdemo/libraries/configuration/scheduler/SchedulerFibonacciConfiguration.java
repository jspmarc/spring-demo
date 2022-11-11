package dev.jspmarc.springdemo.libraries.configuration.scheduler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "scheduler.fibonacci")
public class SchedulerFibonacciConfiguration extends SchedulerConfiguration {

}
