package com.programacao.domain.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programacao.web.fatec.api_fatec.entities.Cliente;

@Repository
public interface  ClienteRepository extends JpaRepository <Cliente, Long> {
    List<Cliente> findByNome(String nome);
}
