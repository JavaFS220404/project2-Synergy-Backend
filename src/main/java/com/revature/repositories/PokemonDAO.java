package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Pokemon;

public interface PokemonDAO extends JpaRepository<Pokemon, Integer>{
	
	/*
	public List<Pokemon> findAll();
	public Optional<Pokemon> findById();
	public void addOrUpdatePokemon(Pokemon pokemon);
	public void destroyPokemon(int id);
	*/

}
