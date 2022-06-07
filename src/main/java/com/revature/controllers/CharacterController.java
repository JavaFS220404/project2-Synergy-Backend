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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Character;
import com.revature.services.CharacterService;



@RestController
@RequestMapping("/character")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CharacterController {
	
private CharacterService characterService;
	
	@Autowired
	public CharacterController(CharacterService characterService) {
		super();
		this.characterService = characterService;
	}
	
//	@GetMapping
//	public ResponseEntity<List<Character>> getCharacters(HttpSession session){
//		if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
//			User user = (User)session.getAttribute("user");
//			List<Character> list = characterService.getAllCharacters(user);
//			return ResponseEntity.status(200).body(list);
//		}
//		return ResponseEntity.status(403).build();
//	}
	@GetMapping
	public List<Character> allCharacters(){
		return characterService.getAllCharacters();
	}
	
	@GetMapping("/{status}")
	public ResponseEntity<List<Character>> getCharacterByStatus(@PathVariable("status")boolean status){
		List<Character> character = characterService.findByStatus(status);
		if(character!=null) {
			return ResponseEntity.status(200).body(character);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("/{house}")
	public ResponseEntity<List<Character>> getCharacterByHome(@PathVariable("house")String hogwartsHouse){
		List<Character> character = characterService.findByHouse(hogwartsHouse);
		if(character!=null) {
			return ResponseEntity.status(200).body(character);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Character> getCharacterId(@PathVariable("id")int id){
		Character character = characterService.findById(id);
		if(character!=null) {
			return ResponseEntity.status(200).body(character);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	

}
