package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avenger {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String superheroName;
	private String firstName;
	private String lastName;
	private String power;
	private int powerLevel;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Home home;

	public Avenger(int id, String superheroName, String firstName, String lastName, String power, int powerLevel,
			Home home) {
		super();
		this.id = id;
		this.superheroName = superheroName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.power = power;
		this.powerLevel = powerLevel;
		this.home = home;
	}

	public Avenger(String superheroName, String firstName, String lastName, String power, int powerLevel, Home home) {
		super();
		this.superheroName = superheroName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.power = power;
		this.powerLevel = powerLevel;
		this.home = home;
	}

	public Avenger() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSuperheroName() {
		return superheroName;
	}

	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, home, id, lastName, power, powerLevel, superheroName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avenger other = (Avenger) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(home, other.home) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(power, other.power)
				&& powerLevel == other.powerLevel && Objects.equals(superheroName, other.superheroName);
	}

	@Override
	public String toString() {
		return "Avenger [id=" + id + ", superheroName=" + superheroName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", power=" + power + ", powerLevel=" + powerLevel + ", home=" + home + "]";
	}
	
	
	
}
