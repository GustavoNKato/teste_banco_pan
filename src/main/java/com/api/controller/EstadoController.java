package com.api.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dtos.EstadoDTO;
import com.api.dtos.MunicipiosDTO;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@GetMapping(value = "/")
	public List<EstadoDTO> listaEstados() {
		return ordenaEstados(new RestTemplateBuilder().build().exchange(
				"https://servicodados.ibge.gov.br/api/v1/localidades/estados/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EstadoDTO>>() {
				}));
	}

	@GetMapping(value = "/{uf}")
	public List<MunicipiosDTO> estadosById(@PathVariable("uf") String uf) {
		List<EstadoDTO> estados = listaEstados();
		String url = null;

		for (EstadoDTO estado : estados) {
			if (uf.toUpperCase().equals(estado.getSigla())) {
				url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + estado.getId() + "/municipios";
			}
		}
		return new RestTemplateBuilder().build()
				.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<MunicipiosDTO>>() {
				}).getBody();
	}

	private List<EstadoDTO> ordenaEstados(ResponseEntity<List<EstadoDTO>> Response) {
		List<EstadoDTO> body = Response.getBody().stream().sorted(Comparator.comparing(EstadoDTO::getSigla))
				.collect(Collectors.toList());

	
        List<EstadoDTO> list = body.stream().filter(s1 -> s1.getSigla().equals("SP")).collect(Collectors.toList());
        list.addAll(body.stream().filter(s1 -> s1.getSigla().equals("RJ")).collect(Collectors.toList()));
        body.removeAll(list);
        body.addAll(0, list);
		
		
		
		
			
//			if (estadoDTO.getSigla().equals("RJ")) {
//				body.set(body.indexOf(estadoDTO), body.get(1));
//				body.set(1, estadoDTO);
//			}
//			
//			if (estadoDTO.getSigla().equals("SP")) {
//				body.set(body.indexOf(estadoDTO), body.get(0));
//				body.set(0, estadoDTO);
//			}
		
		
//		EstadoDTO sp = new EstadoDTO();
//		EstadoDTO rj = new EstadoDTO();
//
//		for (int i = 0; i < body.size(); i++) {
//
//			if (body.get(i).getSigla().equals("SP")) {
//				sp.setId(body.get(i).getId());
//				sp.setNome(body.get(i).getNome());
//				sp.setSigla(body.get(i).getSigla());
//				sp.setRegiao(body.get(i).getRegiao());
//				body.set(0, sp);
//				i = i - 1;
//			}
//
//			if (body.get(i).getSigla().equals("RJ")) {
//				rj.setId(body.get(i).getId());
//				rj.setNome(body.get(i).getNome());
//				rj.setSigla(body.get(i).getSigla());
//				rj.setRegiao(body.get(i).getRegiao());
//				body.set(1, rj);
//				i = i - 1;
//			}
//		}

//		body.add(0, rj);
//		body.add(0, sp);
		return body;
	}

}