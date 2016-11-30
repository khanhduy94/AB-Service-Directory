package com.absd.service;

import java.util.List;

import com.absd.entity.Geography;

//This class  declare methods in Geography Service interface 
public interface GeographyService {
	public long createGeography(Geography geography);

	public Geography updateGeography(Geography geography);

	public void deleteGeography(long id);

	public List<Geography> getAllGeographys();

	public Geography getGeography(long id);

	public List<Geography> getAllGeographys(String geographyName);
}
