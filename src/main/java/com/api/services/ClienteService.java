package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.Cliente;
import com.api.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> encontraTodosOsClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorCPF(String cpf) {
		Cliente obj = clienteRepository.getOne(cpf);
		return obj;
	}
	
}
