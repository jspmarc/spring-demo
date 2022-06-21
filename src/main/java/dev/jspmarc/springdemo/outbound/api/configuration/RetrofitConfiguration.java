package dev.jspmarc.springdemo.outbound.api.configuration;

import dev.jspmarc.springdemo.outbound.api.GitHubEndpointService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfiguration {

  @Bean
  public Retrofit retrofitGitHubEndpointService(GitHubApiProperties gitHubApiProperties) {
    return getRetrofit(gitHubApiProperties);
  }

  @Bean
  public GitHubEndpointService gitHubEndpointService(@Qualifier(value = "retrofitGitHubEndpointService") Retrofit retrofitGitHub) {
    return retrofitGitHub.create(GitHubEndpointService.class);
  }

  private Retrofit getRetrofit(OutboundProperties outboundProperties) {
    return new Retrofit.Builder()
            .baseUrl(outboundProperties.getHost())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
  }
}
