package com.ionix.rest.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column
	private String phone;
	
	public User() {
		
	}

	public User(String name, String userName, String email, String phone) {
		super();
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", email=" + email + ", phone=" + phone
				+ "]";
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
