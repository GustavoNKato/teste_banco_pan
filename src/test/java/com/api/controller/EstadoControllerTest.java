package com.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class EstadoControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testConsultarEstados() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/estados/")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void testConsultarEstadosPorUF() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/estados/RJ")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}
}
