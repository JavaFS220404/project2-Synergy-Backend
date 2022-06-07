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
import com.revature.models.User;
import com.revature.services.CharacterService;
import com.revature.services.FavouriteService;

@RestController
@RequestMapping("/favourite")

public class FavouriteController {

	
	private FavouriteService favouriteService;
	
	@Autowired
	public FavouriteController(FavouriteService favouriteService) {
		super();
		this.favouriteService = favouriteService;
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
}
