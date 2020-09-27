package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
