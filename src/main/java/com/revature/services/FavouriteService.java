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
	private CharacterDAO characterDao;
	
	@Autowired
	public FavouriteService(FavouriteDAO favouriteDao, CharacterDAO characterDao) {
		super();
		this.favouriteDao = favouriteDao;
		this.characterDao = characterDao;
	}
	
	
	public List<Character> viewAllFavouritelist(User user){
	
		List<Favourites> favouriteList  = favouriteDao.findByUserId(user.getId());
		//ToDo
		List<Character> favouriteCharacterList = new ArrayList<>();
       
      for(Favourites favourite : favouriteList) {
    	  //add above favouriteCharacterList 
    	  favouriteCharacterList.add(characterDao.getById(favourite.getCharactersId()));
	
      }
      return null;
	}
	
	public void addFavouriteCharacter(Character character,User user) {
		
		Favourites favourites = new Favourites();
		
		favourites.setUserId(user.getId());
		favourites.setCharactersId(character.getId());
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

	public List<String> getFavCharacters(User user) {
		List<Favourites> allFavourites = favouriteDao.findByUserId(user.getId());
		List<String> favList = new ArrayList<>();
		for(Favourites fav : allFavourites) {
			if(fav.getCharactersId()!=0) {
				favList.add(Integer.toString(fav.getCharactersId()));
			} 
		}
		return favList;
	}

	public List<String> getFavPotions(User user) {
		List<Favourites> allFavourites = favouriteDao.findByUserId(user.getId());
		List<String> favList = new ArrayList<>();
		for(Favourites fav : allFavourites) {
			if(fav.getPotionsId()!=null) {
				favList.add((fav.getPotionsId()));
			} 
		}
		return favList;
	}

	public List<String> getFavSpells(User user) {
		List<Favourites> allFavourites = favouriteDao.findByUserId(user.getId());
		List<String> favList = new ArrayList<>();
		for(Favourites fav : allFavourites) {
			if(fav.getSpellsId()!=null) {
				favList.add((fav.getSpellsId()));
			} 
		}
		return favList;
	}
	
	
		

}
