package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listaClientes() {
		List<Cliente> listaDeClientes = clienteService.encontraTodosOsClientes();
		return ResponseEntity.ok().body(listaDeClientes);
	}
	
	@RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> listaClientesPorCPF(@PathVariable(value = "cpf") String cpf) {
		Cliente cliente = clienteService.buscarPorCPF(cpf);
		return ResponseEntity.ok().body(cliente);
	}
	
}
