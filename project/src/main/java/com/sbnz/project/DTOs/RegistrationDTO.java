package com.sbnz.project.DTOs;

import com.sbnz.project.model.Role;

public class RegistrationDTO {

	private String name;
	private String surname;
	private String username;
	private String password;
	private String repeatedPassword;
	private String role;
	
	public RegistrationDTO() {
		super();
	}

	public RegistrationDTO(String name, String surname, String username, String password, String repeatedPassword, String role) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.repeatedPassword = repeatedPassword;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
