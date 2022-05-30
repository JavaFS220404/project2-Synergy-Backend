package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Character;
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
	
	public void addOrUpdateCharacter(Character character) {
		characterDao.save(character);
	}
	
	public void destroyCharacter(int id) {
		Character character = findById(id);
		characterDao.delete(character);
	}

}
