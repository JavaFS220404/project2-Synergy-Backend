package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wand{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String wood;
	private String core;
	private int length;
	
	public Wand(int id, String wood, String core, int length) {
		super();
		this.id = id;
		this.wood = wood;
		this.core = core;
		this.length = length;
	}
	
	public Wand() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWood() {
		return wood;
	}

	public void setWood(String wood) {
		this.wood = wood;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		return Objects.hash(core, id, length, wood);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wand other = (Wand) obj;
		return Objects.equals(core, other.core) && id == other.id && length == other.length
				&& Objects.equals(wood, other.wood);
	}

	@Override
	public String toString() {
		return "Wand [id=" + id + ", wood=" + wood + ", core=" + core + ", length=" + length + "]";
	}

	
	
	
	
}
