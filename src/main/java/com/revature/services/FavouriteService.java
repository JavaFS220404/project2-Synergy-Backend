package com.revature.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Character;
import com.revature.models.Favourites;
import com.revature.models.Potion;
import com.revature.models.Spell;
import com.revature.models.User;
import com.revature.repositories.CharacterDAO;
import com.revature.repositories.FavouriteDAO;

@Service
public class FavouriteService {
	private FavouriteDAO favouriteDao;
	
	@Autowired
	public FavouriteService(FavouriteDAO favouriteDao) {
		super();
		this.favouriteDao = favouriteDao;
	}
	
	public List<Character> viewAllFavouritelist(User user){
	
		List<Favourites> favouriteList  = favouriteDao.findByUserId(user.getId());
		//ToDo
		List<Character> favouriteCharacterList = new ArrayList<>();
       
      for(Favourites favourite : favouriteList) {
    	  //add above favouriteCharacterList 
    	  favouriteCharacterList.add(favourite.getCharacter());
	
      }
      return favouriteCharacterList;
	}
	
	public void addFavouriteCharacter(Character character,User user) {
		
		Favourites favourites = new Favourites();
		
		favourites.setUserId(user.getId());
		favourites.setCharacter(character);
		//favourites.setPotionsId("potionsId");
		//favourites.setSpellsId("spellsId");
		favouriteDao.save(favourites);
	}
	
	public void destroyCharacter(int id) {
		
		favouriteDao.deleteById(id);
	}
	
	public void addFavouritePotion(Potion potion,User user) {
			Favourites favourites = new Favourites();
			favourites.setUserId(user.getId());
			favourites.setPotionsId(potion.getId());
			favouriteDao.save(favourites);
		}
	
	public void addFavouriteSpell(Spell spell,User user) {
		Favourites favourites = new Favourites();
		favourites.setUserId(user.getId());
		favourites.setSpellsId(spell.getId());
		favouriteDao.save(favourites);
	}
	
	
		

}
