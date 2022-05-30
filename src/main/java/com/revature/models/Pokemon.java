package com.revature.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pokedexId;
	
	private String name;
	private int baseXP;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn
	@JsonBackReference
	private Trainer trainer;

	public Pokemon(int pokedexId, String name, int baseXP, Trainer trainer) {
		super();
		this.pokedexId = pokedexId;
		this.name = name;
		this.baseXP = baseXP;
		this.trainer = trainer;
	}

	public Pokemon(String name, int baseXP, Trainer trainer) {
		super();
		this.name = name;
		this.baseXP = baseXP;
		this.trainer = trainer;
	}

	public Pokemon() {
		super();
	}

	public int getPokedexId() {
		return pokedexId;
	}

	public void setPokedexId(int pokedexId) {
		this.pokedexId = pokedexId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseXP() {
		return baseXP;
	}

	public void setBaseXP(int baseXP) {
		this.baseXP = baseXP;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseXP, name, pokedexId, trainer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return baseXP == other.baseXP && Objects.equals(name, other.name) && pokedexId == other.pokedexId
				&& Objects.equals(trainer, other.trainer);
	}

	@Override
	public String toString() {
		return "Pokemon [pokedexId=" + pokedexId + ", name=" + name + ", baseXP=" + baseXP + ", trainer=" + trainer
				+ "]";
	}
	
	

}
