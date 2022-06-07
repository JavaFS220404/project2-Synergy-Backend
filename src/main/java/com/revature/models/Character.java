package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Character{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	private String nickname;
	@Column(nullable=false)
	private boolean hogwartsStudent;
	@Column(nullable=false)
	private String hogwartsHouse;
	@Column(nullable=false)
	private String interpretedBy;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="parents_children", 
	                joinColumns={@JoinColumn(name="parent_id")}, 
	                inverseJoinColumns={@JoinColumn(name="child_id")})
	private List<Character> parents;
	//@ManyToMany(fetch=FetchType.EAGER)
	
	@ManyToMany(mappedBy = "parents", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Character> children;
	
	private String image;

	public Character() {
		super();
	}

	

	public Character(int id, String name, String nickname, boolean hogwartsStudent, String hogwartsHouse,
			String interpretedBy, List<Character> parents, List<Character> children, String image) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.hogwartsStudent = hogwartsStudent;
		this.hogwartsHouse = hogwartsHouse;
		this.interpretedBy = interpretedBy;
		this.parents = parents;
		this.children = children;
		this.image = image;
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



	public List<Character> getParents() {
		return parents;
	}



	public void setParents(List<Character> parents) {
		this.parents = parents;
	}



	public List<Character> getChildren() {
		return children;
	}



	public void setChildren(List<Character> children) {
		this.children = children;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public int hashCode() {
		return Objects.hash(children, hogwartsHouse, hogwartsStudent, id, image, interpretedBy, name, nickname,
				parents);
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
		return Objects.equals(children, other.children) && Objects.equals(hogwartsHouse, other.hogwartsHouse)
				&& hogwartsStudent == other.hogwartsStudent && id == other.id && Objects.equals(image, other.image)
				&& Objects.equals(interpretedBy, other.interpretedBy) && Objects.equals(name, other.name)
				&& Objects.equals(nickname, other.nickname) && Objects.equals(parents, other.parents);
	}



	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", nickname=" + nickname + ", hogwartsStudent="
				+ hogwartsStudent + ", hogwartsHouse=" + hogwartsHouse + ", interpretedBy=" + interpretedBy
				+ ", parents=" + parents + ", children=" + children + ", image=" + image + "]";
	}



	
	
}
	
	