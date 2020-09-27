package com.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.dtos.EnderecoDTO;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*")
public class CepController {

    @GetMapping(value = "/{cep}")
    public EnderecoDTO cep(@PathVariable("cep") String cep) {
        return new RestTemplate().getForObject("https://viacep.com.br/ws/" + cep + "/json", EnderecoDTO.class);
    }
}