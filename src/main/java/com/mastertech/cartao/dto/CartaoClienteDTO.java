package com.mastertech.cartao.dto;

import java.io.Serializable;

public class CartaoClienteDTO implements Serializable {

    private int idCartao;
    private String numero;
    private int idCliente;
    private String nome;
    private boolean ativo;

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
