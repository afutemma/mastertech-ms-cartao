package com.mastertech.cartao.client;

import feign.Feign;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class ClienteClientConfiguration {

    @Bean
    public ErrorDecoder getErrorDecoder(){
        return new ClienteClientDecoder();
    }
}
