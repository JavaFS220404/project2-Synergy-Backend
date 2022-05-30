package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Spell implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String incantation;
	private String effect;
	private boolean canBeVerbal;
	private String type;
	private String light;
	private String creator;
	
	public Spell(int id, String name, String incantation, String effect, boolean canBeVerbal, String type, String light,
			String creator) {
		super();
		this.id = id;
		this.name = name;
		this.incantation = incantation;
		this.effect = effect;
		this.canBeVerbal = canBeVerbal;
		this.type = type;
		this.light = light;
		this.creator = creator;
	}

	public Spell() {
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

	public String getIncantation() {
		return incantation;
	}

	public void setIncantation(String incantation) {
		this.incantation = incantation;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public boolean isCanBeVerbal() {
		return canBeVerbal;
	}

	public void setCanBeVerbal(boolean canBeVerbal) {
		this.canBeVerbal = canBeVerbal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public int hashCode() {
		return Objects.hash(canBeVerbal, creator, effect, id, incantation, light, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spell other = (Spell) obj;
		return canBeVerbal == other.canBeVerbal && Objects.equals(creator, other.creator)
				&& Objects.equals(effect, other.effect) && id == other.id
				&& Objects.equals(incantation, other.incantation) && Objects.equals(light, other.light)
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Spell [id=" + id + ", name=" + name + ", incantation=" + incantation + ", effect=" + effect
				+ ", canBeVerbal=" + canBeVerbal + ", type=" + type + ", light=" + light + ", creator=" + creator + "]";
	}
	
	
	
	
	

}
