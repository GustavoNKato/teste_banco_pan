package com.api.repositories;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.dtos.EstadoDTO;
import com.api.dtos.MunicipiosDTO;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@GetMapping()
	public ResponseEntity<List<EstadoDTO>> listaEstados() {
		return new RestTemplate(new HttpComponentsClientHttpRequestFactory()).exchange(
				"https://servicodados.ibge.gov.br/api/v1/localidades/estados/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EstadoDTO>>() {
				});
	}

	@GetMapping(value = "/{uf}")
    public List<MunicipiosDTO> estadosById(@PathVariable("uf") String uf) {
        List<EstadoDTO> estados = (List<EstadoDTO>) listaEstados();
        String url = null;

        for (EstadoDTO estado: estados) {
            if (uf.toUpperCase().equals( estado.getSigla())) {
                url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + estado.getId() + "/municipios";
            }
        }
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory()).exchange(
                url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<MunicipiosDTO>>() {
                }).getBody();
    }
}