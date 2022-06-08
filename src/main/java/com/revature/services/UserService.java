package com.revature.services;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

@Service
public class UserService {
	
	private UserDAO userDao;

	@Autowired
	public UserService(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}
	
	public User login(User attempt) {
		Optional<User> opt = userDao.findByUsername(attempt.getUsername());
		if(opt.isPresent()) {
			User dbUser = opt.get();
			if(dbUser.getPassword().equals(attempt.getPassword())) {
				return dbUser;
			}
		}
		return null;
	}
	
	public boolean register(User user){
		user.setId(0);
		user = userDao.save(user);
		if(user.getId()!=0) {
			return true;
		}
		return false;
	}
	
	public User Update(User home) {
		User dbUser = userDao.save(home); //save will saveOrUpdate in SpringData JPA
		return dbUser;
	}


}