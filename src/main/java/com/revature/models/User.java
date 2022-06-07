package com.revature.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	private int createDate;
	@Column(nullable=false)
	private int countryCode;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn( name = "userId",referencedColumnName = "userId")
	private UserDetails userDetails;

	public User(int id, String userName, String password, int createDate, int countryCode, UserDetails userDetails) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.createDate = createDate;
		this.countryCode = countryCode;
		this.userDetails = userDetails;
	}

	public User() {
		super();
	}

	public User(String userName, String password, int createDate, int countryCode, UserDetails userDetails) {
		super();
		this.userName = userName;
		this.password = password;
		this.createDate = createDate;
		this.countryCode = countryCode;
		this.userDetails = userDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCreateDate() {
		return createDate;
	}

	public void setCreateDate(int createDate) {
		this.createDate = createDate;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "User [Id=" + id + ", userName=" + userName + ", password=" + password + ", createDate=" + createDate
				+ ", countryCode=" + countryCode + ", userDetails=" + userDetails + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, countryCode, createDate, password, userDetails, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && countryCode == other.countryCode && createDate == other.createDate
				&& Objects.equals(password, other.password) && Objects.equals(userDetails, other.userDetails)
				&& Objects.equals(userName, other.userName);
	}
	
	
	
	

}

