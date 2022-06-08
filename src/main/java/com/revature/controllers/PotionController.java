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

import com.revature.models.Potion;
import com.revature.services.PotionService;

@RestController
@RequestMapping("/potion")
public class PotionController {
	
private PotionService potionService;
	
	@Autowired
	public PotionController(PotionService potionService) {
		super();
		this.potionService = potionService;
	}
	
	@GetMapping
	public List<Potion> allPotions(){
		return potionService.getAllPotions();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Potion> onePotion(@PathVariable("id") String id){
		Potion potion = potionService.findById(id);
		if(potion!=null) {
			return ResponseEntity.status(200).body(potion);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Potion> addPotion(@RequestBody Potion potion){
		potionService.addOrUpdatePotion(potion);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<Potion> updatePotion(@RequestBody Potion potion){
		potionService.addOrUpdatePotion(potion);
		return ResponseEntity.status(202).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Potion> deletePotion(@PathVariable("id") String id){
		potionService.destroyPotion(id);
		return ResponseEntity.status(202).build();
	}
	

}
