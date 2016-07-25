package com.pokemon.service;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.Mockito.mock;

import com.pokemon.dao.PokemonDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.pokemon.service")
@ContextConfiguration(classes = RepositoryTestSetUp.class)
@WebAppConfiguration
public class RepositoryTestSetUp {
	
	@Bean
	public PokemonDao getPokemonDao() {

		return mock(PokemonDao.class);
	}

}
