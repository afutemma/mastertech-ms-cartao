package com.mastertech.cartao.controller;

import com.mastertech.cartao.dto.CartaoDTO;
import com.mastertech.cartao.dto.CartaoStatusDTO;
import com.mastertech.cartao.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartaoController {

    @Autowired
    private CartaoService service;

    @PostMapping("/cartao")
    public ResponseEntity postCartao(@RequestBody CartaoDTO cartao) {
        return ResponseEntity.ok(service.salvar(cartao));
    }


    @GetMapping("/cartao/{numero}")
    public ResponseEntity getCartao(@PathVariable String numero) {
        return ResponseEntity.ok(service.buscarPorNumero(numero));
    }

    @GetMapping("/cartao/{idCartao}/cliente/{idCliente}")
    public ResponseEntity getCartaoCliente(@PathVariable int idCartao, @PathVariable int idCliente) {
        return ResponseEntity.ok(service.buscarClienteCartao(idCliente, idCartao));
    }

    @GetMapping("/cartao/byId/{id}")
    public ResponseEntity getCartao(@PathVariable int id) {
        return ResponseEntity.ok(service.buscaPorId(id));
    }


    @PatchMapping("/cartao/{numero}")
    public ResponseEntity setStatus(@PathVariable String numero, @RequestBody CartaoStatusDTO status) {
        return ResponseEntity.ok(service.ativar(numero, status));
    }

}
