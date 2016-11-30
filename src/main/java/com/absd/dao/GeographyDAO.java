/**
 * 
 */
package com.absd.dao;

import java.util.List;

import com.absd.entity.Geography;

//Declare the DAO class-class help web-app query database
public interface GeographyDAO {
	// Create new geography method
	public long createGeography(Geography geography);

	// Update the geography method
	public Geography updateGeography(Geography geography);

	// Delete geography method
	public void deleteGeography(long id);

	// Get all geography in the list
	public List<Geography> getAllGeographys();

	// Get geography -user search by ID
	public Geography getGeography(long id);

	// Get all geography in the list when user filter by name
	public List<Geography> getAllGeographys(String geographyName);
}
