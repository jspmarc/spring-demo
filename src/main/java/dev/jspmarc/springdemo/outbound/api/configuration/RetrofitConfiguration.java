package dev.jspmarc.springdemo.outbound.api.configuration;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfiguration {
    private Retrofit getRetrofit(OutboundProperties outboundProperties) {
        return new Retrofit.Builder()
                .baseUrl(outboundProperties.getHost())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
