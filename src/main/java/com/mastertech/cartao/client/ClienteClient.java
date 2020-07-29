package com.mastertech.cartao.client;

import com.mastertech.cartao.model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cliente")
public interface ClienteClient {

    @GetMapping("/cliente/{id}")
    Cliente getClienteById(@PathVariable String id);

}
