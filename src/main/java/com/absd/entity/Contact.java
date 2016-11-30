package com.absd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * @author DuyDK
 * @version 1.0
 * 
 */
@Entity
@Table(name = "Contact")
public class Contact implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String conName;

	@Column
	private String conType;

	@Column
	private int phone;

	@Column
	private String email;

	@Column
	private String managerName;

	public Contact() {
	}

	public Contact(String _name, String _conType, int _phone, String _email,
			String _managerName) {
		conName = _name;
		conType = _conType;
		phone = _phone;
		email = _email;
		managerName = _managerName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getConType() {
		return conType;
	}

	public void setConType(String conType) {
		this.conType = conType;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact{" + "id=" + id + ", conName=" + conName + '\''
				+ ", conType=" + conType + ", phone=" + phone + ", email="
				+ email + ", managerName=" + managerName + "}";
	}
}