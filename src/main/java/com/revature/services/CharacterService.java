package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Character;

import com.revature.models.Trainer;
import com.revature.repositories.CharacterDAO;

@Service
public class CharacterService {

	private CharacterDAO characterDao;
	
	@Autowired
	public CharacterService(CharacterDAO characterDao) {
		super();
		this.characterDao = characterDao;
	}
	
	public List<Character> getAllCharacters(){
		return characterDao.findAll();
	}
	
	public Character findById(int id) {
		Optional<Character> opt = characterDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public List<Character> findByHouse(String hogwartsHouse) {
		Optional<List<Character>> opt = characterDao.findByHogwartsHouse(hogwartsHouse);
		if(opt.isPresent()) {
			return opt.get();
		}return new ArrayList<Character>();
	}
	
	
	
	public List<Character> findByStatus(boolean hogwartsStudent) {
		Optional<List<Character>> opt = characterDao.findByHogwartsStudent(hogwartsStudent);
		if(opt.isPresent()) {
			return opt.get();
		}return new ArrayList<Character>();
	}

}
