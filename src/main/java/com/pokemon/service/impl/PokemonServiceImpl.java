package com.pokemon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.dao.PokemonDao;
import com.pokemon.model.Pokemon;
import com.pokemon.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {

	private final static String YELLOW_POKEMON = "yellow";

	private PokemonDao pokemonDao;

	@Autowired
	public PokemonServiceImpl(PokemonDao pokemonDao) {
		this.pokemonDao = pokemonDao;
	}

	public boolean savePokemon(Pokemon pokemon) {
		boolean result = false;
		try {
			if (pokemonDao.save(pokemon) != null) {
				result = true;
			}
		} catch (Exception exception) {
			result = false;
		}
		return result;
	}

	@Override
	public boolean deletePokemon(Pokemon pokemon) {
		boolean result = pokemon != null && !pokemon.getColor().equals(YELLOW_POKEMON);
		try {
			if (result) {
				pokemonDao.delete(pokemon);
			}
		} catch (Exception exception) {
			result = false;
		}
		return result;
	}

	@Override
	public boolean updatePokemon(Pokemon pokemon) {
		boolean result = pokemon != null;

		try {
			if (result) {
				Pokemon updated = pokemonDao.findByIdPokemon(pokemon.getIdPokemon());
				updated.update(pokemon.getColor(), pokemon.getName(), pokemon.getType());
				pokemonDao.flush();
			}
		} catch (Exception exception) {
			result = false;
		}

		return result;

	}

	@Override
	public List<Pokemon> findAllPokemon() {
		return pokemonDao.findAll();
	}

	@Override
	public List<Pokemon> findAllPokemonByColor(String color) {
		return pokemonDao.findAllByColor(color);
	}

}
