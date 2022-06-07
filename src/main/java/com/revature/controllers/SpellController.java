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

import com.revature.models.Spell;
import com.revature.services.SpellService;

@RestController
@RequestMapping("/spell")
public class SpellController {
	
private SpellService spellService;
	
	@Autowired
	public SpellController(SpellService spellService) {
		super();
		this.spellService = spellService;
	}
	
	@GetMapping
	public List<Spell> allSpells(){
		return spellService.getAllSpells();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Spell> oneSpell(@PathVariable("id")int id){
		Spell spell = spellService.findById(id);
		if(spell!=null) {
			return ResponseEntity.status(200).body(spell);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
//	@PostMapping
//	public ResponseEntity<Spell> addSpell(@RequestBody Spell spell){
//		spellService.addOrUpdateSpell(spell);
//		return ResponseEntity.status(201).build();
//	}
//	
//	@PutMapping
//	public ResponseEntity<Spell> updateSpell(@RequestBody Spell spell){
//		spellService.addOrUpdateSpell(spell);
//		return ResponseEntity.status(202).build();
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Spell> deleteSpell(@PathVariable("id") int id){
//		spellService.destroySpell(id);
//		return ResponseEntity.status(202).build();
//	}
	

}
