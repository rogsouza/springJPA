package com.example.springJPA.entity;

import java.util.Set;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MYSQL */

/*
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	
	@ManyToMany
	private Set<Role> roles;
	
	
	public User() {
		super();
	}
	
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
*/

/**
 * mongoDB */

@Document
public class User {
	
	@Id
	private String id;
	private String name;
	private String email;
	
	private Set<Role> roles;
	
	
	public User() {
		super();
	}
	
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

