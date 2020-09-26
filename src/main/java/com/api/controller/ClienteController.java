package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Cliente;
import com.api.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {	
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Cliente> listaClientes() {
		return clienteService.encontraTodosOsClientes();
	}
	
	@RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
	public Cliente listaClientesPorCPF(@PathVariable(value = "cpf") String cpf) {
		return clienteService.buscarPorCPF(cpf);
	}
	
}
