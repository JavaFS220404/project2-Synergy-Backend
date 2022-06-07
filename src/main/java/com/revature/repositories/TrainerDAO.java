package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Trainer;

public interface TrainerDAO extends JpaRepository<Trainer,Integer>{
	
	/*
	public List<Trainer> findAll();
	public Optional<Trainer> findById(int id);
	public Trainer addOrUpdateTrainer(Trainer trainer);
	*/

}
