package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Avenger;
import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.services.PokemonService;
import com.revature.services.TrainerService;
import com.revature.services.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	private PokemonService pokemonService;
	private TrainerService trainerService;
	
	@Autowired
	public PokemonController(PokemonService pokemonService,TrainerService trainerService) {
		super();
		this.pokemonService = pokemonService;
		this.trainerService = trainerService;
	}
	
	@GetMapping
	public List<Trainer> allTrainers(){
		return trainerService.getAllTrainers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Trainer> oneTrainer(@PathVariable("id")int id){
		Trainer trainer = trainerService.findById(id);
		if(trainer!=null) {
			return ResponseEntity.status(200).body(trainer);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@PostMapping
	public List<Trainer> addTrainer(@RequestBody Trainer trainer){
		trainerService.addOrUpdateTrainer(trainer);
		return trainerService.getAllTrainers();
	}
	
	@PutMapping
	public List<Trainer> addPokemon(@RequestBody Pokemon pokemon){
		pokemonService.addOrUpdatePokemon(pokemon);
		return trainerService.getAllTrainers();
	}

}
