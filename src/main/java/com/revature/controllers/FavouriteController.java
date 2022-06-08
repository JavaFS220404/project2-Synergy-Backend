package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Character;
import com.revature.models.Potion;
import com.revature.models.Spell;
import com.revature.models.User;
import com.revature.services.CharacterService;
import com.revature.services.FavouriteService;
import com.revature.services.PotionService;
import com.revature.services.SpellService;

@RestController
@RequestMapping("/favourite")

public class FavouriteController {

	
	private FavouriteService favouriteService;
	private PotionService potionService;
	private CharacterService characterService;
	private SpellService spellService;
	
	@Autowired
	public FavouriteController(FavouriteService favouriteService, PotionService potionService,
			CharacterService characterService, SpellService spellService) {
		super();
		this.favouriteService = favouriteService;
		this.potionService = potionService;
		this.characterService = characterService;
		this.spellService = spellService;
	}
	
	private User getUser(){
		User user = new User();
		user.setId(3);
		return user;
		}
	
	

	@GetMapping
	public List<Character> viewAllFavouritelist(){
		User user = getUser();
		return favouriteService.viewAllFavouritelist(user);
	}
	@PostMapping
	public ResponseEntity<Character> addFavourite(@RequestBody Character character){
		//if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
			//User user = (User)session.getAttribute("user");

		User user = getUser();
			favouriteService.addFavouriteCharacter(character,user);
			return ResponseEntity.status(201).build();
		//}
		//return ResponseEntity.status(403).build();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Character> deleteFavourite(@PathVariable("id") int id){
		favouriteService.destroyCharacter(id);
		return ResponseEntity.status(200).build();
	}
	
	
	
	
	//Mapping individual favorites
	
	@PostMapping("/character/{id}")
	public ResponseEntity<Character> addFavouriteCharacter(@PathVariable("id") int id, HttpSession session){
		//if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
			//User user = (User)session.getAttribute("user");

		User user = getUser();
		Character character = characterService.findById(id);
		favouriteService.addFavouriteCharacter(character,user);
		return ResponseEntity.status(201).build();
		//}
		//return ResponseEntity.status(403).build();
	}
	
	@PostMapping("/potion/{id}")
	public ResponseEntity<Potion> addFavouritePotion(@PathVariable("id") int id, HttpSession session){
		//if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
			//User user = (User)session.getAttribute("user");

		User user = getUser();
		Potion potion = potionService.findById(id);
		favouriteService.addFavouritePotion(potion,user);
		return ResponseEntity.status(201).build();
		//}
		//return ResponseEntity.status(403).build();
	}
	
	@PostMapping("/spell/{id}")
	public ResponseEntity<Spell> addFavouriteSpell(@PathVariable("id") int id, HttpSession session){
		//if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
			//User user = (User)session.getAttribute("user");

		User user = getUser();
		Spell spell = spellService.findById(id);
		favouriteService.addFavouriteSpell(spell,user);
		return ResponseEntity.status(201).build();
		//}
		//return ResponseEntity.status(403).build();
	}
}
