package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Character{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String character;
	private String nickname;
	private boolean hogwartsStudent;
	private String hogwartsHouse;
	private String interpretedBy;
	
	@ElementCollection
	private List<String> child;
	
	private String image;

	public Character(int id, String character, String nickname, boolean hogwartsStudent, String hogwartsHouse,
			String interpretedBy, List<String> child, String image) {
		super();
		this.id = id;
		this.character = character;
		this.nickname = nickname;
		this.hogwartsStudent = hogwartsStudent;
		this.hogwartsHouse = hogwartsHouse;
		this.interpretedBy = interpretedBy;
		this.child = child;
		this.image = image;
	}

	public Character(String character, String nickname, boolean hogwartsStudent, String hogwartsHouse,
			String interpretedBy, List<String> child, String image) {
		super();
		this.character = character;
		this.nickname = nickname;
		this.hogwartsStudent = hogwartsStudent;
		this.hogwartsHouse = hogwartsHouse;
		this.interpretedBy = interpretedBy;
		this.child = child;
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

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isHogwartsStudent() {
		return hogwartsStudent;
	}

	public void setHogwartsStudent(boolean hogwartsStudent) {
		this.hogwartsStudent = hogwartsStudent;
	}

	public String getHogwartsHouse() {
		return hogwartsHouse;
	}

	public void setHogwartsHouse(String hogwartsHouse) {
		this.hogwartsHouse = hogwartsHouse;
	}

	public String getInterpretedBy() {
		return interpretedBy;
	}

	public void setInterpretedBy(String interpretedBy) {
		this.interpretedBy = interpretedBy;
	}

	public List<String> getChild() {
		return child;
	}

	public void setChild(List<String> child) {
		this.child = child;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(character, child, hogwartsHouse, hogwartsStudent, id, image, interpretedBy, nickname);
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
		return Objects.equals(character, other.character) && Objects.equals(child, other.child)
				&& Objects.equals(hogwartsHouse, other.hogwartsHouse) && hogwartsStudent == other.hogwartsStudent
				&& id == other.id && Objects.equals(image, other.image)
				&& Objects.equals(interpretedBy, other.interpretedBy) && Objects.equals(nickname, other.nickname);
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", character=" + character + ", nickname=" + nickname + ", hogwartsStudent="
				+ hogwartsStudent + ", hogwartsHouse=" + hogwartsHouse + ", interpretedBy=" + interpretedBy + ", child="
				+ child + ", image=" + image + "]";
	}
	
	
	
	
	
}
	/*
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
	*/
	
	
	
	