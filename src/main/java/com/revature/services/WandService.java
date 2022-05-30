package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Wand;
import com.revature.repositories.WandDAO;

@Service
public class WandService {

	private WandDAO wandDao;
	
	@Autowired
	public WandService(WandDAO wandDao) {
		super();
		this.wandDao = wandDao;
	}
	
	public List<Wand> getAllWands(){
		return wandDao.findAll();
	}
	
	public Wand findById(int id) {
		Optional<Wand> opt = wandDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public void addOrUpdateWand(Wand wand) {
		wandDao.save(wand); 
	}
	
	public void destroyWand(int id) {
		Wand wand = findById(id);
		wandDao.delete(wand);
	}
	
}
