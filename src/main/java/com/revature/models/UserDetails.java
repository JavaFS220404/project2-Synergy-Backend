package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	
    @Id
	private int userId;
	private String firstName;
	private String lastName;
	private String eMail;
	public UserDetails(int userId, String firstName, String lastName, String eMail) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}
	public UserDetails() {
		super();
	}
	public UserDetails(String firstName, String lastName, String eMail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", eMail="
				+ eMail + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(eMail, firstName, lastName, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		return Objects.equals(eMail, other.eMail) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && userId == other.userId;
	}
	
	

}
