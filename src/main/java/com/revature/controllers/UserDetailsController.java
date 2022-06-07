package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.UserDetails;
import com.revature.services.UserDetailsService;

@RestController
@RequestMapping("/userdetails")


public class UserDetailsController {
private UserDetailsService userDetailsService;
	
	@Autowired
	public UserDetailsController(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}
	@PutMapping
	public ResponseEntity<UserDetails> updateCharacter(@RequestBody UserDetails userDetails){
		userDetailsService.addOrUpdateCharacter(userDetails);
		return ResponseEntity.status(200).build();
}
	

}
