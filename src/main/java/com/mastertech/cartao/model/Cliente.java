package com.mastertech.cartao.model;

import javax.persistence.*;
import java.io.Serializable;

public class Cliente implements Serializable {

    private int idCliente;
    private String nome;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCLiente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
