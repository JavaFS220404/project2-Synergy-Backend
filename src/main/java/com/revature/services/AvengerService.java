package com.revature.services;

import java.util.List;

import com.revature.daos.AvengerDAO;
import com.revature.daos.AvengerDAOHibImpl;
import com.revature.daos.AvengerDAOImpl;
import com.revature.models.Avenger;

public class AvengerService {
	
	AvengerDAO avengerDao = new AvengerDAOHibImpl();
	
	public List<Avenger> findAll(){
		return avengerDao.findAll();
	}
	
	public Avenger findById(int id) {
		return avengerDao.findById(id);
	}
	
	public boolean addAvenger(Avenger avenger) {
		return avengerDao.addAvenger(avenger);
	}

	public boolean updateAvenger(Avenger avenger) {
		return avengerDao.updateAvenger(avenger);
	}
	
	public boolean deleteAvenger(int id) {
		return avengerDao.deleteAvenger(id);
	}
		
}
