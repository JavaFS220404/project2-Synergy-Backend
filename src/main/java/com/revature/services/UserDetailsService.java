package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.models.UserDetails;
import com.revature.repositories.UserDetailsDAO;

@Service
public class UserDetailsService {
	
	private UserDetailsDAO userDetailsDao;
	
	@Autowired
	public UserDetailsService(UserDetailsDAO userDetailsDao) {
		super();
		this.userDetailsDao = userDetailsDao;
	}
	
	public void addOrUpdateCharacter(UserDetails userdetails) {
		userDetailsDao.save(userdetails);
	}

}
