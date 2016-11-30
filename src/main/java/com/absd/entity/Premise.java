package com.absd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Declare Entity mapping to the Table in database
@Entity
@Table(name = "Premise")
public class Premise {

	// ID of the Entity
	@Id
	// This field has auto increment value
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// Column of Table in Database
	@Column
	private String preName;
	@Column
	private String address;
	@Column
	private int phone;
	@Column
	private String postCode;
	@Column
	private String email;

	//
	public Premise() {
	}

	//
	public Premise(String _name, String _address, String _postCode, int _phone,
			String _email) {
		preName = _name;
		address = _address;
		postCode = _postCode;
		phone = _phone;
		email = _email;
	}

	//
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//
	public String getPreName() {
		return preName;
	}

	public void setPreName(String preName) {
		this.preName = preName;
	}

	//
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phoneNumber) {
		this.phone = phoneNumber;
	}

	//
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	//
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}