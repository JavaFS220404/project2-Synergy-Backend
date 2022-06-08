package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class Favourites {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int userId;
	private int charactersId;
	private String potionsId;
	private String spellsId;
	
	public Favourites(int id, int userId, int charactersId, String potionsId, String spellsId) {
		super();
		this.id = id;
		this.userId = userId;
		this.charactersId = charactersId;
		this.potionsId = potionsId;
		this.spellsId = spellsId;
	}

	public Favourites() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCharactersId() {
		return charactersId;
	}

	public void setCharactersId(int charactersId) {
		this.charactersId = charactersId;
	}

	public String getPotionsId() {
		return potionsId;
	}

	public void setPotionsId(String potionsId) {
		this.potionsId = potionsId;
	}

	public String getSpellsId() {
		return spellsId;
	}

	public void setSpellsId(String spellsId) {
		this.spellsId = spellsId;
	}
	
	
	
	
}
