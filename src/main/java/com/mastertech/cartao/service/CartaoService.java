package com.mastertech.cartao.service;

import com.mastertech.cartao.client.ClienteClient;
import com.mastertech.cartao.dto.CartaoClienteDTO;
import com.mastertech.cartao.dto.CartaoDTO;
import com.mastertech.cartao.dto.CartaoStatusDTO;
import com.mastertech.cartao.exceptions.CartaoNaoEncontradoException;
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

    public Optional<Cartao> buscaPorId(int id){
        return repository.findById(id);
    }


    public CartaoDTO buscarPorNumero(String numero){
        List<Cartao> c = repository.findByNumero(numero);
        Cartao cartao = c.get(0);
        CartaoDTO dto = new CartaoDTO();
        dto.setIdCartao(cartao.getIdCartao());
        dto.setAtivo(cartao.isAtivo());
        dto.setIdCliente(cartao.getIdCliente());
        dto.setNumero(cartao.getNumero());

        return dto;
    }

    public CartaoDTO salvar(CartaoDTO cadastro){
        Cartao cartao = new Cartao();
        Cliente cliente = new Cliente();
        cliente = clienteClient.getClientePorId(String.valueOf(cadastro.getIdCliente()));
        cartao.setNumero(cadastro.getNumero());
        cartao.setIdCliente(cadastro.getIdCliente());
        cartao.setAtivo(false);

        repository.save(cartao);

        cadastro.setIdCartao(cartao.getIdCartao());

        return cadastro;
    }

    public CartaoClienteDTO buscarClienteCartao(int idCliente, int idCartao){
        Optional<Cartao> op = buscaPorId(idCartao);
        CartaoClienteDTO response = new CartaoClienteDTO();

        if(!op.isPresent()){
            throw new CartaoNaoEncontradoException();
        }

        Cartao cartao = op.get();
        Cliente cliente = new Cliente();

        cliente = clienteClient.getClientePorId(String.valueOf(idCliente));

        response.setNome(cliente.getNome());
        response.setNumero(cartao.getNumero());
        response.setIdCliente(cartao.getIdCliente());
        response.setAtivo(cartao.isAtivo());
        response.setIdCartao(cartao.getIdCartao());

        return response;

    }

    public List<Cartao> buscaTodos() {
        return repository.findAll();
    }

    public CartaoDTO ativar(String numero, CartaoStatusDTO status){
        List<Cartao> c = repository.findByNumero(numero);
        Cartao cartao = c.get(0);
        cartao.setAtivo(status.isAtivo());
        repository.save(cartao);
        CartaoDTO dto = new CartaoDTO();
        dto.setIdCartao(cartao.getIdCartao());
        dto.setAtivo(cartao.isAtivo());
        dto.setIdCliente(cartao.getIdCliente());
        dto.setNumero(cartao.getNumero());

        return dto;
    }

}
