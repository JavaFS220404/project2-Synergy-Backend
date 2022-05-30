package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.repositories.AvengerDAO;
import com.revature.repositories.PokemonDAO;

@Service
public class PokemonService {
	
	private PokemonDAO pokemonDao;
	private TrainerService trainerService;
	
	@Autowired
	public PokemonService(PokemonDAO pokemonDao) {
		super();
		this.pokemonDao = pokemonDao;
	}
	
	public List<Pokemon> getAllPokemons(){
		return pokemonDao.findAll();
	}
	
	public Pokemon findById(int id) {
		Optional<Pokemon> opt = pokemonDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public void addOrUpdatePokemon(Pokemon pokemon) {
		/*
		if(pokemon.getTrainer()!=null &&  pokemon.getTrainer().gettId()==0){
			Trainer trainer = trainerService.addOrUpdateTrainer(pokemon.getTrainer());
			pokemon.setTrainer(trainer);
		}*/
		pokemonDao.save(pokemon);
	}
	
	public void destroyPokemon(int id) {
		Pokemon pokemon = findById(id);
		pokemonDao.delete(pokemon);
	}
	

}
