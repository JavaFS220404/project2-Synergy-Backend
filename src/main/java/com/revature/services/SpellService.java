package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Spell;
import com.revature.repositories.SpellDAO;

@Service
public class SpellService {

	private SpellDAO spellDao;
	
	@Autowired
	public SpellService(SpellDAO spellDao) {
		super();
		this.spellDao = spellDao;
	}
	
	public List<Spell> getAllSpells(){
		return spellDao.findAll();
	}
	
	public Spell findById(int id) {
		Optional<Spell> opt = spellDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
//	public void addOrUpdateSpell(Spell spell) {
//		spellDao.save(spell); 
//	}
//	
//	public void destroySpell(int id) {
//		Spell spell = findById(id);
//		spellDao.delete(spell);
//	}
	
}
