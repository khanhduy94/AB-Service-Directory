package com.absd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Geography")
// This class declare Geography object include attributes , methods
public class Geography implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String countryName;

	@Column
	private String region;

	@Column
	private String district;

	@Column
	private String description;

	public Geography() {
	}

	public Geography(String _countryName, String _region, String _district,
			String _description) {
		countryName = _countryName;
		region = _region;
		district = _district;
		description = _description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Geography{" + "id=" + id + ", countryName='" + countryName
				+ '\'' + ", region=" + region + ", district=" + district
				+ ", description=" + description + '}';
	}
}