/**
 * class OrganizationEntity
 */
package com.absd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * @author ToanNX
 * @version 1.0
 */

@Entity
@Table(name = "Organisation")
public class Organisation implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	// Id of Organization, Id is auto
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// Name of Organization
	@Column
	private String orgName;

	// Address of Organization
	@Column
	private String address;

	// Post Code of Organization
	@Column
	private String postCode;

	// Phone Number of Organization
	@Column
	private int phone;

	// Email of Organization
	@Column
	private String email;

	// Constructor default
	public Organisation() {
	}

	// Constructor 
	public Organisation(String _name, String _address, String _postCode,
			int _phone, String _email) {
		orgName = _name;
		address = _address;
		postCode = _postCode;
		phone = _phone;
		email = _email;
	}

	// get value Id of Organization 
	public long getId() {
		return id;
	}

	// set value Id of Organization
	public void setId(long id) {
		this.id = id;
	}

	// get value Name of Organization
	public String getOrgName() {
		return orgName;
	}

	// set value Name of Organization
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	// get value Address of Organization
	public String getAddress() {
		return address;
	}

	// set value Address of Organization
	public void setAddress(String address) {
		this.address = address;
	}

	// get value Post Code of Organization
	public String getPostCode() {
		return postCode;
	}

	// set value Post Code of Organization
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	// get value Phone Number of Organization
	public int getPhone() {
		return phone;
	}

	// set value Phone Number of Organization
	public void setPhone(int phone) {
		this.phone = phone;
	}

	// get value Email of Organization
	public String getEmail() {
		return email;
	}

	// set value Email of Organization
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Organisation{" + "id=" + id + ", orgName='" + orgName + '\''
				+ ", address=" + address + ", postCose=" + postCode
				+ ", phone=" + phone + ", email=" + email + '}';
	}
}