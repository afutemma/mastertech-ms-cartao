package com.mastertech.cartao.client;

import feign.Feign;
import feign.RequestInterceptor;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

public class ClienteClientConfiguration {


    @Autowired
    private OAuth2ClientContext oAuth2ClientContext;

    @Autowired
    private ClientCredentialsResourceDetails clientCredentialsResourceDetails;


    @Bean
    public ErrorDecoder getErrorDecoder(){
        return new ClienteClientDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators feignDecorators = FeignDecorators.builder()
                .withFallback(new ClienteClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(feignDecorators);
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(oAuth2ClientContext, clientCredentialsResourceDetails);
    }


}
