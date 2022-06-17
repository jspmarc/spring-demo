package dev.jspmarc.springdemo.outbound.api.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "github")
public class GitHubApiProperties extends OutboundProperties {
}
