/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kudasa.ems.users.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author abdussamad
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "surname")
	private String surname;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "other_name")
	private String otherName;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@Column(name = "department")
	private String department;
	@Column(name = "unit")
	private String unit;
	@Column(name = "rank")
	private String rank;
	@Column(name = "photo")
	private byte[] photo;


	private Operations[] operations;	
	@Embedded
	private Credential credential;

	public User() {
	}

	
	public User(Long id, String surname, String firstName, String otherName, String email, String phone, String department, String unit, String rank, byte[] photo, Operations[] operations) {
		this.id = id;
		this.surname = surname;
		this.firstName = firstName;
		this.otherName = otherName;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.unit = unit;
		this.rank = rank;
		this.photo = photo;
		this.operations = operations;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
		public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Operations[] getOperations() {
		return operations;
	}

	public void setOperations(Operations[] operations) {
		this.operations = operations;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	

	
	
}
