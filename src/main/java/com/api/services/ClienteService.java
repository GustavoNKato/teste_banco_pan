package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.exception.ResourceNotFoundException;
import com.api.models.Cliente;
import com.api.models.Endereco;
import com.api.repositories.ClienteRepository;
import com.api.repositories.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	public List<Cliente> encontraTodosOsClientes() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPorCPF(String cpf) {
		return clienteRepository.findById(cpf)
				.orElseThrow(() -> new ResourceNotFoundException("Customer with cpf " + cpf + " not found"));
	}

	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

}
