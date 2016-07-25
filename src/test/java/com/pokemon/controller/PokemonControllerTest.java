package com.pokemon.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.pokemon.model.Pokemon;
import com.pokemon.service.PokemonService;

public class PokemonControllerTest extends ServiceTestSetUp {

	@Autowired
	PokemonService pokemonService;

	@Test
	public void retrieveOuterRedPokemonsTest() throws Exception {
		doReturn(new ArrayList<Pokemon>()).when(pokemonService).findAllPokemonByColor("red");
		mockMvc.perform(get("/pokemonGo/outerRedPokemons").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void savePokemonTestOK() throws Exception {
		doReturn(true).when(pokemonService).savePokemon(any(Pokemon.class));
		mockMvc.perform(post("/pokemonGo/savePokemon").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void savePokemonBAD() throws Exception {
		doReturn(false).when(pokemonService).savePokemon(any(Pokemon.class));
		mockMvc.perform(post("/pokemonGo/savePokemon").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void updatePokemonTestOK() throws Exception {
		doReturn(true).when(pokemonService).updatePokemon(any(Pokemon.class));
		mockMvc.perform(post("/pokemonGo/updatePokemon").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void upadtePokemonBAD() throws Exception {
		doReturn(false).when(pokemonService).updatePokemon(any(Pokemon.class));
		mockMvc.perform(post("/pokemonGo/updatePokemon").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void deletePokemonTestOK() throws Exception {
		doReturn(true).when(pokemonService).deletePokemon(any(Pokemon.class));
		mockMvc.perform(post("/pokemonGo/deletePokemon").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void deletePokemonBAD() throws Exception {
		doReturn(false).when(pokemonService).deletePokemon(any(Pokemon.class));
		mockMvc.perform(post("/pokemonGo/deletePokemon").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void getAllPokemonsTest() throws Exception {
		doReturn(new ArrayList<Pokemon>()).when(pokemonService).findAllPokemon();
		mockMvc.perform(get("/pokemonGo/getAllPokemons").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
