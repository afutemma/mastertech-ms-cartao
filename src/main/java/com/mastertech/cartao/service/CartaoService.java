package com.mastertech.cartao.service;

import com.mastertech.cartao.client.ClienteClient;
import com.mastertech.cartao.dto.CartaoDTO;
import com.mastertech.cartao.model.Cartao;
import com.mastertech.cartao.model.Cliente;
import com.mastertech.cartao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository repository;
    @Autowired
    private ClienteClient clienteClient;

    public Optional<Cartao> findById(int id){
        return repository.findById(id);
    }


    public CartaoDTO findByNumero(String numero){
        List<Cartao> c = repository.findByNumero(numero);
        Cartao cartao = c.get(0);
        CartaoDTO dto = new CartaoDTO();
        dto.setIdCartao(cartao.getIdCartao());
        dto.setAtivo(cartao.isAtivo());
        dto.setClienteId(cartao.getClienteId());
        dto.setNumero(cartao.getNumero());

        return dto;
    }

    public CartaoDTO save(CartaoDTO cadastro){
        Cartao cartao = new Cartao();
        Cliente cliente = new Cliente();
        cliente = clienteClient.getClienteById(String.valueOf(cadastro.getClienteId()));
        cartao.setNumero(cadastro.getNumero());
        cartao.setClienteId(cliente.getIdCliente());
        cartao.setAtivo(false);

        repository.save(cartao);

        cadastro.setIdCartao(cartao.getIdCartao());

        return cadastro;
    }

    public List<Cartao> findAll() {
        return repository.findAll();
    }

    public CartaoDTO ativar(String numero){
        List<Cartao> c = repository.findByNumero(numero);
        Cartao cartao = c.get(0);
        cartao.setAtivo(true);
        repository.save(cartao);
        CartaoDTO dto = new CartaoDTO();
        dto.setIdCartao(cartao.getIdCartao());
        dto.setAtivo(cartao.isAtivo());
        dto.setClienteId(cartao.getClienteId());
        dto.setNumero(cartao.getNumero());

        return dto;
    }
}
