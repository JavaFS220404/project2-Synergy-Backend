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

import com.revature.models.Wand;
import com.revature.services.WandService;

@RestController
@RequestMapping("/wand")
public class WandController {
	
private WandService wandService;
	
	@Autowired
	public WandController(WandService wandService) {
		super();
		this.wandService = wandService;
	}
	
	@GetMapping
	public List<Wand> allWands(){
		return wandService.getAllWands();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Wand> oneWand(@PathVariable("id")int id){
		Wand wand = wandService.findById(id);
		if(wand!=null) {
			return ResponseEntity.status(200).body(wand);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Wand> addWand(@RequestBody Wand wand){
		wandService.addOrUpdateWand(wand);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<Wand> updateWand(@RequestBody Wand wand){
		wandService.addOrUpdateWand(wand);
		return ResponseEntity.status(202).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Wand> deleteWand(@PathVariable("id") int id){
		wandService.destroyWand(id);
		return ResponseEntity.status(202).build();
	}
	

}
