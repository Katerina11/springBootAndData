package com.pokemon.service;

import java.util.List;

import com.pokemon.model.Pokemon;

public interface PokemonService {

	boolean savePokemon(Pokemon pokemon);

	boolean deletePokemon(Pokemon pokemon);

	boolean updatePokemon(Pokemon pokemon);

	List<Pokemon> findAllPokemon();

	List<Pokemon> findAllPokemonByColor(String color);

}
