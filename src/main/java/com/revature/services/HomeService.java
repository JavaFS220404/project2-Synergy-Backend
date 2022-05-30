package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Home;
import com.revature.repositories.HomeDAO;

@Service
public class HomeService {
	
	private HomeDAO homeDao;
	
	@Autowired
	public HomeService(HomeDAO homeDao) {
		super();
		this.homeDao = homeDao;
	}
	
	public List<Home> getAllHomes(){
		return homeDao.findAll();
	}
	
	public Home findById(int id) {
		Optional<Home> opt = homeDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public Home addOrUpdateHome(Home home) {
		Home dbHome = homeDao.save(home); //save will saveOrUpdate in Spring Data Jpa
		return dbHome;
	}
	
	public void destroyHome(int id) {
		Home home = findById(id);
		homeDao.delete(home);
	}

}
