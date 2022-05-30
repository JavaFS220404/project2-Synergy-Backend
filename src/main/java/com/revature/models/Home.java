package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Home {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	private String streetAddress;
	private String streetName;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	public Home(int id, String name, String streetAddress, String streetName, String city, String region,
			String postalCode, String country) {
		super();
		this.id = id;
		this.name = name;
		this.streetAddress = streetAddress;
		this.streetName = streetName;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	public Home(String name, String streetAddress, String streetName, String city, String region, String postalCode,
			String country) {
		super();
		this.name = name;
		this.streetAddress = streetAddress;
		this.streetName = streetName;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	public Home() {
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, id, name, postalCode, region, streetAddress, streetName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Home other = (Home) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(region, other.region) && Objects.equals(streetAddress, other.streetAddress)
				&& Objects.equals(streetName, other.streetName);
	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", name=" + name + ", streetAddress=" + streetAddress + ", streetName=" + streetName
				+ ", city=" + city + ", region=" + region + ", postalCode=" + postalCode + ", country=" + country + "]";
	}

	
	
	
	
}
