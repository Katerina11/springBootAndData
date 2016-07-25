package com.pokemon.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pokemon.dao.PokemonDao;
import com.pokemon.model.Pokemon;
import com.pokemon.service.impl.PokemonServiceImpl;

public class PokemonServiceTest extends RepositoryTestSetUp {

	@Autowired
	PokemonDao pokemonDao;

	PokemonService pokemonService;

	@Before
	public void setUp() {
		pokemonService = new PokemonServiceImpl(pokemonDao);
	}

	@Test
	public void savePokemonTest() {
		Pokemon pokemonReady = new Pokemon();
		Pokemon pokemonNotReady = new Pokemon();
		doReturn(pokemonReady).when(pokemonDao).save(pokemonReady);
		doReturn(null).when(pokemonDao).save(pokemonNotReady);
		Assert.assertTrue(pokemonService.savePokemon(pokemonReady));
		Assert.assertFalse(pokemonService.savePokemon(pokemonNotReady));
	}

	@Test
	public void deletePokemonTest() {

		Pokemon pokemonNotDeleted = new Pokemon("yellow", "normal", "Cleffa");
		Pokemon pokemonDeleted = new Pokemon("red", "normal", "Cleffa");
		doNothing().when(pokemonDao).delete(pokemonDeleted);

		Assert.assertFalse(pokemonService.deletePokemon(pokemonNotDeleted));
		Assert.assertTrue(pokemonService.deletePokemon(pokemonDeleted));
	}

	@Test
	public void updatePokemonTest() {

		Pokemon updatePokemon = new Pokemon("yellow", "normal", "Cleffa");
		Pokemon notUpdate = null;
		doReturn(updatePokemon).when(pokemonDao).findByIdPokemon(any(Integer.class));
		doNothing().when(pokemonDao).flush();

		Assert.assertFalse(pokemonService.updatePokemon(notUpdate));
		Assert.assertTrue(pokemonService.updatePokemon(updatePokemon));
	}

	@Test
	public void findAllPokemonTest() {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		pokemons.add(new Pokemon());
		pokemons.add(new Pokemon());
		doReturn(pokemons).when(pokemonDao).findAll();
		Assert.assertTrue(pokemonService.findAllPokemon().size() == 2);
	}

	@Test
	public void findAllPokemonByColorTest() {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		pokemons.add(new Pokemon("red", "normal", "Cleffa"));
		pokemons.add(new Pokemon("red", "normal", "Pidgey"));
		doReturn(pokemons).when(pokemonDao).findAllByColor("red");
		Assert.assertTrue(pokemonService.findAllPokemonByColor("red").size() == 2);
	}
}
