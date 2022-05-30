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

import com.revature.models.Home;
import com.revature.services.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	private HomeService homeService;
	
	@Autowired
	public HomeController(HomeService homeService) {
		super();
		this.homeService = homeService;
	}
	
	@GetMapping
	public List<Home> allHomes(){
		return homeService.getAllHomes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Home> oneHome(@PathVariable("id")int id){
		Home home = homeService.findById(id);
		if(home!=null) {
			return ResponseEntity.status(200).body(home);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Home> addHome(@RequestBody Home home){
		homeService.addOrUpdateHome(home);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<Home> updateHome(@RequestBody Home home){
		homeService.addOrUpdateHome(home);
		return ResponseEntity.status(202).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Home> deleteHome(@PathVariable("id") int id){
		homeService.destroyHome(id);
		return ResponseEntity.status(202).build();
	}
	
	
	

}
