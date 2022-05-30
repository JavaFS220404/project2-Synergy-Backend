package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Trainer;
import com.revature.models.Trainer;
import com.revature.repositories.TrainerDAO;

@Service
public class TrainerService {
	
	private TrainerDAO trainerDao;
	
	@Autowired
	public TrainerService(TrainerDAO trainerDao) {
		super();
		this.trainerDao = trainerDao;
	}
	
	public List<Trainer> getAllTrainers(){
		return trainerDao.findAll();
	}
	
	public Trainer findById(int id) {
		Optional<Trainer> opt = trainerDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	/*
	public Trainer addOrUpdateTrainer(Trainer trainer) {
		Trainer dbTrainer = trainerDao.save(trainer);
		return dbTrainer;
	}*/
	
	public void addOrUpdateTrainer(Trainer trainer) {
		trainerDao.save(trainer);
	}

}
