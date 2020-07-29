package com.mastertech.cartao.repository;

import com.mastertech.cartao.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

    List<Cartao> findByNumero(String numero);
}
