package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.dtos.EnderecoDTO;
import com.api.models.Cliente;
import com.api.models.Endereco;
import com.api.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {	
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
    CepController cepController;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Cliente> listaClientes() {
		return clienteService.encontraTodosOsClientes();
	}
	
	@RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
	public Cliente listaClientesPorCPF(@PathVariable(value = "cpf") String cpf) {
		return clienteService.buscarPorCPF(cpf);
	}
	
	@RequestMapping(value = "/{cpf}", method = RequestMethod.PUT)
    public ResponseEntity<EnderecoDTO> alterarEnderecoCliente(@RequestBody EnderecoDTO enderecoDTO,
    		@PathVariable(value = "cpf") String cpf, BindingResult result) {
        EnderecoDTO cep = cepController.cep(enderecoDTO.getCep());
        Endereco endereco = dtoToEndereco(enderecoDTO, cep);
        Optional<Endereco> enderecoSalvo = Optional.ofNullable(clienteService.salvar(endereco));
        return ResponseEntity.ok(enderecoToDTO(enderecoSalvo.get()));
	}
	
    private EnderecoDTO enderecoToDTO(Endereco enderecoSalvo) {
    	EnderecoDTO enderecoDTO = new EnderecoDTO();
    	enderecoDTO.setCep(enderecoSalvo.getCep());
    	enderecoDTO.setBairro(enderecoSalvo.getBairro());
    	enderecoDTO.setLogradouro(enderecoSalvo.getLogradouro());
    	enderecoDTO.setNumero(enderecoSalvo.getNumero());
    	enderecoDTO.setUf(enderecoSalvo.getUf());
        return enderecoDTO;
    }

    private Endereco dtoToEndereco(EnderecoDTO enderecoDTO, EnderecoDTO cep) {
        Endereco endereco = new Endereco();
        Optional.ofNullable(enderecoDTO.getIdEndereco()).ifPresent(a -> endereco.setCod(a));
        endereco.setCep(enderecoDTO.getCep());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setUf(enderecoDTO.getUf());
        return endereco;
    }

    
    
    
}
