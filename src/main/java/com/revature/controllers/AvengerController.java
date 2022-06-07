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

import com.revature.models.Avenger;
import com.revature.services.AvengerService;

@RestController
@RequestMapping("/avenger")
public class AvengerController {
	
private AvengerService avengerService;
	
	@Autowired
	public AvengerController(AvengerService avengerService) {
		super();
		this.avengerService = avengerService;
	}
	
	@GetMapping
	public List<Avenger> allAvengers(){
		return avengerService.getAllAvengers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Avenger> oneAvenger(@PathVariable("id")int id){
		Avenger avenger = avengerService.findById(id);
		if(avenger!=null) {
			return ResponseEntity.status(200).body(avenger);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Avenger> addAvenger(@RequestBody Avenger avenger){
		avengerService.addOrUpdateAvenger(avenger);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<Avenger> updateAvenger(@RequestBody Avenger avenger){
		avengerService.addOrUpdateAvenger(avenger);
		return ResponseEntity.status(202).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Avenger> deleteAvenger(@PathVariable("id") int id){
		avengerService.destroyAvenger(id);
		return ResponseEntity.status(202).build();
	}
	
	@GetMapping("/name/{heroName}")
	public List<Avenger> getHerosByName(@PathVariable("heroName") String name){
		List<Avenger> list = avengerService.getBySuperheroName(name);
		return list;
	}

}
