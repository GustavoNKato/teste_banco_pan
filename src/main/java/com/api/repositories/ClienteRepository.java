package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

	//public List<Cliente> findByCpf(String cpf);
	
}
