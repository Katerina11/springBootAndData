package com.pokemon.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.mock;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pokemon.service.PokemonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.pokemon.controller")
@ContextConfiguration(classes = ServiceTestSetUp.class)
@WebAppConfiguration
@EnableWebMvc
public class ServiceTestSetUp {

	protected MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext wac;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Bean
	public PokemonService getPokemonService() {
		return mock(PokemonService.class);
	}

}
