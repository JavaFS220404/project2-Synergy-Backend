package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.revature.repositories.UserDAO;
import com.revature.services.CharacterService;
import com.revature.services.FavouriteService;
import com.revature.services.PotionService;
import com.revature.services.SpellService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/favourite")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class FavouriteController {

	
	private FavouriteService favouriteService;
	private PotionService potionService;
	private CharacterService characterService;
	private SpellService spellService;
	private UserDAO userDao;
	
	@Autowired
	public FavouriteController(FavouriteService favouriteService, PotionService potionService,
			CharacterService characterService, SpellService spellService, UserDAO userDao) {
		super();
		this.favouriteService = favouriteService;
		this.potionService = potionService;
		this.characterService = characterService;
		this.spellService = spellService;
		this.userDao = userDao;
	}

	/*
	@GetMapping
	public List<Character> viewAllFavouritelist(){
		User user = getUser();
		return favouriteService.viewAllFavouritelist(user);
	}*/
	@PostMapping
	public ResponseEntity<Character> addFavourite(@RequestBody Character character, HttpSession session){
		if(session.getAttribute("loggedin")!=null&&(Boolean)session.getAttribute("loggedin")) {
			User user = (User)session.getAttribute("user");
			//User user = getUser();
			favouriteService.addFavouriteCharacter(character,user);
			return ResponseEntity.status(201).build();
		}
		return ResponseEntity.status(403).build();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Character> deleteFavourite(@PathVariable("id") int id){
		favouriteService.destroyCharacter(id);
		return ResponseEntity.status(200).build();
	}
	
	
	
	
	//Mapping individual favorites
	
	@PostMapping("/character/{id}")
	public ResponseEntity<Character> addFavouriteCharacter(@PathVariable("id") int id, HttpSession session){
		System.out.println("user: "+(User)session.getAttribute("user"));
		System.out.println("loggedin: "+session.getAttribute("loggedin"));
		if(session.getAttribute("loggedin")!=null && (Boolean)session.getAttribute("loggedin")) {
			User user = (User)session.getAttribute("user");
			Character character = new Character();
			character.setId(id);
			favouriteService.addFavouriteCharacter(character,user);
			return ResponseEntity.status(201).build();
		}
		return ResponseEntity.status(403).build();
	}
	
	@PostMapping("/potion/{id}")
	public ResponseEntity<Potion> addFavouritePotion(@PathVariable("id") String id, HttpSession session){
		System.out.println("user: "+(User)session.getAttribute("user"));
		System.out.println("loggedin: "+session.getAttribute("loggedin"));
		if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("loggedin")) {
			User user = (User)session.getAttribute("user");
			Potion potion = new Potion();
			potion.setId(id);
			favouriteService.addFavouritePotion(potion,user);
			return ResponseEntity.status(201).build();
		}
		return ResponseEntity.status(403).build();
	}
	
	@PostMapping("/spell/{id}")
	public ResponseEntity<Spell> addFavouriteSpell(@PathVariable("id") String id, HttpSession session){
		System.out.println("user: "+(User)session.getAttribute("user"));
		System.out.println("loggedin: "+session.getAttribute("loggedin"));
		if(session.getAttribute("loggedin")!=null && (Boolean)session.getAttribute("loggedin")) {
			User user = (User)session.getAttribute("user");
			Spell spell = new Spell();
			spell.setId(id);
			favouriteService.addFavouriteSpell(spell,user);
			return ResponseEntity.status(201).build();
		}
		return ResponseEntity.status(403).build();
	}
	
	
	
	//Mapping get favourites
	
	@GetMapping("/character")
	public List<String> getFavCharacters(HttpSession session){
		if(session.getAttribute("loggedin")!=null && (Boolean)session.getAttribute("loggedin")) {
			User user = (User)session.getAttribute("user");
			return favouriteService.getFavCharacters(user);
		}
		return null;
	}
	
	@GetMapping("/potion")
	public List<String> getFavPotions(HttpSession session){
		if(session.getAttribute("loggedin")!=null && (Boolean)session.getAttribute("loggedin")) {
			User user = (User)session.getAttribute("user");
			return favouriteService.getFavPotions(user);
		}
		return null;
	}
	
	@GetMapping("/spell")
	public List<String> getFavSpells(HttpSession session){
		if(session.getAttribute("loggedin")!=null && (Boolean)session.getAttribute("loggedin")) {
			User user = (User)session.getAttribute("user");
			return favouriteService.getFavSpells(user);
		}
		return null;
	}
	/*
	@DeleteMapping("/spell/{id}")
	public ResponseEntity<Spell> deleteSpellFromFavs(@PathVariable("id") String id, HttpSession session){
		if(session.getAttribute("loggedin")!=null && (Boolean)session.getAttribute("loggedin")) {
			User user = (User)session.getAttribute("user");
			Spell spell = new Spell();
			spell.setId(id);
			favouriteService.addFavouriteSpell(spell,user);
			return ResponseEntity.status(201).build();
		}
		return ResponseEntity.status(403).build();
	}
	
	@DeleteMapping("/spell/{id}")
	public ResponseEntity<Character> deleteFavourite(@PathVariable("id") int id){
		favouriteService.destroyCharacter(id);
		return ResponseEntity.status(200).build();
	}*/
	
}
