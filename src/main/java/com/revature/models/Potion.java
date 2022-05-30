package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Potion{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String effect;
	private String sideEffects;
	private String characteristics;
	private String time;
	private String difficulty;
	private List<Ingredient> ingredients;
	private String inventors;
	private String manufacturer;
	
	public Potion(int id, String name, String effect, String sideEffects, String characteristics, String time,
			String difficulty, List<Ingredient> ingredients, String inventors, String manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.effect = effect;
		this.sideEffects = sideEffects;
		this.characteristics = characteristics;
		this.time = time;
		this.difficulty = difficulty;
		this.ingredients = ingredients;
		this.inventors = inventors;
		this.manufacturer = manufacturer;
	}
	
	public Potion() {
		super();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getSideEffects() {
		return sideEffects;
	}

	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getInventors() {
		return inventors;
	}

	public void setInventors(String inventors) {
		this.inventors = inventors;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(characteristics, difficulty, effect, id, ingredients, inventors, manufacturer, name,
				sideEffects, time);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Potion other = (Potion) obj;
		return Objects.equals(characteristics, other.characteristics) && Objects.equals(difficulty, other.difficulty)
				&& Objects.equals(effect, other.effect) && id == other.id
				&& Objects.equals(ingredients, other.ingredients) && Objects.equals(inventors, other.inventors)
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(name, other.name)
				&& Objects.equals(sideEffects, other.sideEffects) && Objects.equals(time, other.time);
	}
	
	@Override
	public String toString() {
		return "Potion [id=" + id + ", name=" + name + ", effect=" + effect + ", sideEffects=" + sideEffects
				+ ", characteristics=" + characteristics + ", time=" + time + ", difficulty=" + difficulty
				+ ", ingredients=" + ingredients + ", inventors=" + inventors + ", manufacturer=" + manufacturer + "]";
	}
	
	

}
