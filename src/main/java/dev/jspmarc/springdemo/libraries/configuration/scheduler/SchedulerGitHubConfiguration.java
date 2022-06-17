package dev.jspmarc.springdemo.libraries.configuration.scheduler;

import com.tiket.tix.hotel.cart.libraries.configuration.scheduler.SchedulerConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "scheduler.github")
public class SchedulerGitHubConfiguration extends SchedulerConfiguration {
}
