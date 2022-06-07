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
	@OneToOne(fetch=FetchType.EAGER)
	private Character character;
	private int potionsId;
	private int spellsId;
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

	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public int getPotionsId() {
		return potionsId;
	}
	public void setPotionsId(int potionsId) {
		this.potionsId = potionsId;
	}
	public int getSpellsId() {
		return spellsId;
	}
	public void setSpellsId(int spellsId) {
		this.spellsId = spellsId;
	}	
	
	
}
