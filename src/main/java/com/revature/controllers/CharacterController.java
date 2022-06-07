package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Character;
import com.revature.services.CharacterService;

@RestController
@RequestMapping("/character")
public class CharacterController {
	
private CharacterService characterService;
	
	@Autowired
	public CharacterController(CharacterService characterService) {
		super();
		this.characterService = characterService;
	}
	
	@GetMapping
	public List<Character> allCharacters(){
		return characterService.getAllCharacters();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Character> oneCharacter(@PathVariable("id")int id){
		Character character = characterService.findById(id);
		if(character!=null) {
			return ResponseEntity.status(200).body(character);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Character> addCharacter(@RequestBody Character character){
		characterService.addOrUpdateCharacter(character);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<Character> updateCharacter(@RequestBody Character character){
		characterService.addOrUpdateCharacter(character);
		return ResponseEntity.status(202).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Character> deleteCharacter(@PathVariable("id") int id){
		characterService.destroyCharacter(id);
		return ResponseEntity.status(202).build();
	}
	

}
