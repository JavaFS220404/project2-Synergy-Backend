package com.revature.models;

//import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Character{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String alternate_names;
	private String species;
	private String gender;
	private String house;
	private String dateOfBirth;
	private int yearOfBirth;
	private boolean wizard;
	private String ancestry;
	private String eyeColour;
	private String hairColour;
	
	@OneToOne
	private Wand wand;
	
	private String patronus;
	private boolean hogwartsStudent;
	private boolean hogwartsStaff;
	private String actor;
	
	@ElementCollection
	private List<String> alternate_actors;
	
	private boolean alive;
	private String image;
	
	
	public Character(int id, String name, String alternate_names, String species, String gender, String house,
			String dateOfBirth, int yearOfBirth, boolean wizard, String ancestry, String eyeColour, String hairColour,
			Wand wand, String patronus, boolean hogwartsStudent, boolean hogwartsStaff, String actor,
			List<String> alternate_actors, boolean alive, String image) {
		super();
		this.id = id;
		this.name = name;
		this.alternate_names = alternate_names;
		this.species = species;
		this.gender = gender;
		this.house = house;
		this.dateOfBirth = dateOfBirth;
		this.yearOfBirth = yearOfBirth;
		this.wizard = wizard;
		this.ancestry = ancestry;
		this.eyeColour = eyeColour;
		this.hairColour = hairColour;
		this.wand = wand;
		this.patronus = patronus;
		this.hogwartsStudent = hogwartsStudent;
		this.hogwartsStaff = hogwartsStaff;
		this.actor = actor;
		this.alternate_actors = alternate_actors;
		this.alive = alive;
		this.image = image;
	}
	
	public Character() {
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

	public String getAlternate_names() {
		return alternate_names;
	}

	public void setAlternate_names(String alternate_names) {
		this.alternate_names = alternate_names;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public boolean isWizard() {
		return wizard;
	}

	public void setWizard(boolean wizard) {
		this.wizard = wizard;
	}

	public String getAncestry() {
		return ancestry;
	}

	public void setAncestry(String ancestry) {
		this.ancestry = ancestry;
	}

	public String getEyeColour() {
		return eyeColour;
	}

	public void setEyeColour(String eyeColour) {
		this.eyeColour = eyeColour;
	}

	public String getHairColour() {
		return hairColour;
	}

	public void setHairColour(String hairColour) {
		this.hairColour = hairColour;
	}

	public Wand getWand() {
		return wand;
	}

	public void setWand(Wand wand) {
		this.wand = wand;
	}

	public String getPatronus() {
		return patronus;
	}

	public void setPatronus(String patronus) {
		this.patronus = patronus;
	}

	public boolean isHogwartsStudent() {
		return hogwartsStudent;
	}

	public void setHogwartsStudent(boolean hogwartsStudent) {
		this.hogwartsStudent = hogwartsStudent;
	}

	public boolean isHogwartsStaff() {
		return hogwartsStaff;
	}

	public void setHogwartsStaff(boolean hogwartsStaff) {
		this.hogwartsStaff = hogwartsStaff;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public List<String> getAlternate_actors() {
		return alternate_actors;
	}

	public void setAlternate_actors(List<String> alternate_actors) {
		this.alternate_actors = alternate_actors;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actor, alive, alternate_actors, alternate_names, ancestry, dateOfBirth, eyeColour, gender,
				hairColour, hogwartsStaff, hogwartsStudent, house, id, image, name, patronus, species, wand, wizard,
				yearOfBirth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		return Objects.equals(actor, other.actor) && alive == other.alive
				&& Objects.equals(alternate_actors, other.alternate_actors)
				&& Objects.equals(alternate_names, other.alternate_names) && Objects.equals(ancestry, other.ancestry)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(eyeColour, other.eyeColour)
				&& Objects.equals(gender, other.gender) && Objects.equals(hairColour, other.hairColour)
				&& hogwartsStaff == other.hogwartsStaff && hogwartsStudent == other.hogwartsStudent
				&& Objects.equals(house, other.house) && id == other.id && Objects.equals(image, other.image)
				&& Objects.equals(name, other.name) && Objects.equals(patronus, other.patronus)
				&& Objects.equals(species, other.species) && Objects.equals(wand, other.wand) && wizard == other.wizard
				&& yearOfBirth == other.yearOfBirth;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", alternate_names=" + alternate_names + ", species="
				+ species + ", gender=" + gender + ", house=" + house + ", dateOfBirth=" + dateOfBirth
				+ ", yearOfBirth=" + yearOfBirth + ", wizard=" + wizard + ", ancestry=" + ancestry + ", eyeColour="
				+ eyeColour + ", hairColour=" + hairColour + ", wand=" + wand + ", patronus=" + patronus
				+ ", hogwartsStudent=" + hogwartsStudent + ", hogwartsStaff=" + hogwartsStaff + ", actor=" + actor
				+ ", alternate_actors=" + alternate_actors + ", alive=" + alive + ", image=" + image + "]";
	}
	
	
	
}
