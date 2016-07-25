package com.pokemon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.model.Pokemon;
import java.lang.Integer;

@Repository
public interface PokemonDao extends JpaRepository<Pokemon, Integer> {

	@SuppressWarnings("unchecked")
	Pokemon save(Pokemon pokemon);

	void delete(Pokemon pokemon);

	List<Pokemon> findAll();

	Pokemon findByIdPokemon(Integer id);

	List<Pokemon> findAllByColor(String color);

}
