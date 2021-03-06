package com.revature.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> loginAttempt(@RequestBody User user, HttpSession session) {
		user = userService.login(user);
		if (user != null) {
			session.setAttribute("loggedin", true);
			session.setAttribute("user", user);
			System.out.println(user);
			user.setPassword(null);
			return ResponseEntity.status(200).body(user);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@PostMapping("/register")
	public ResponseEntity<User> registration(@RequestBody User user) {
		boolean registered = false;
		registered = userService.register(user);
		if (registered) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}


	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user){
		userService.Update(user);
		return ResponseEntity.status(200).build();
}
	


}