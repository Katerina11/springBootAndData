package com.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.model.Pokemon;
import com.pokemon.service.PokemonService;

@RestController
@RequestMapping("/pokemonGo")
public class PokemonController {

	private static final String POKEMON_WAS_NOT_DELETED = "Pokemon was  not deleted";
	private static final String POKEMON_WAS_SUCCESSFULLY_DELETED = "Pokemon was successfully deleted";
	private static final String POKEMON_WAS_NOT_UPDATED = "Pokemon was  not updated";
	private static final String POKEMON_WAS_SUCCESSFULLY_UPDATED = "Pokemon was successfully updated";
	private static final String POKEMON_WAS_NOT_SAVED = "Pokemon was  not saved";
	private static final String POKEMON_WAS_SUCCESSFULLY_SAVED = "Pokemon was successfully saved";
	private static final String RED = "red";
	
	
	@Autowired
	PokemonService pokemonService;

	@RequestMapping(value = "/outerRedPokemons", method = RequestMethod.GET)
	public ResponseEntity<List<Pokemon>> retrieveOuterRedPokemons() {

		List<Pokemon> pokemons = pokemonService.findAllPokemonByColor(RED);
		return new ResponseEntity<List<Pokemon>>(pokemons, HttpStatus.OK);
	}

	@RequestMapping(value = "/savePokemon", method = RequestMethod.POST)
	public ResponseEntity<String> savePokemon(Pokemon pokemon) {
		ResponseEntity<String> response;

		boolean result = pokemonService.savePokemon(pokemon);
		if (result) {
			response = new ResponseEntity<String>(POKEMON_WAS_SUCCESSFULLY_SAVED, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>(POKEMON_WAS_NOT_SAVED, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@RequestMapping(value = "/updatePokemon", method = RequestMethod.POST)
	public ResponseEntity<String> updatePokemon(Pokemon pokemon) {
		ResponseEntity<String> response;

		boolean result = pokemonService.updatePokemon(pokemon);
		if (result) {
			response = new ResponseEntity<String>(POKEMON_WAS_SUCCESSFULLY_UPDATED, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>(POKEMON_WAS_NOT_UPDATED, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@RequestMapping(value = "/deletePokemon", method = RequestMethod.POST)
	public ResponseEntity<String> deletePokemon(Pokemon pokemon) {
		ResponseEntity<String> response;

		boolean result = pokemonService.deletePokemon(pokemon);
		if (result) {
			response = new ResponseEntity<String>(POKEMON_WAS_SUCCESSFULLY_DELETED, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>(POKEMON_WAS_NOT_DELETED, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@RequestMapping(value = "/getAllPokemons", method = RequestMethod.GET)
	public ResponseEntity<List<Pokemon>> retrieveAllPokemons() {

		List<Pokemon> pokemons = pokemonService.findAllPokemon();
		return new ResponseEntity<List<Pokemon>>(pokemons, HttpStatus.OK);
	}
}
