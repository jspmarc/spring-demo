package dev.jspmarc.springdemo.libraries.configuration.scheduler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "scheduler.github")
public class SchedulerGitHubConfiguration extends SchedulerConfiguration {
}
