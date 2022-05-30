package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Potion;
import com.revature.repositories.PotionDAO;

@Service
public class PotionService {

	private PotionDAO potionDao;
	
	@Autowired
	public PotionService(PotionDAO potionDao) {
		super();
		this.potionDao = potionDao;
	}
	
	public List<Potion> getAllPotions(){
		return potionDao.findAll();
	}
	
	public Potion findById(int id) {
		Optional<Potion> opt = potionDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public void addOrUpdatePotion(Potion potion) {
		potionDao.save(potion); 
	}
	
	public void destroyPotion(int id) {
		Potion potion = findById(id);
		potionDao.delete(potion);
	}
	
}
