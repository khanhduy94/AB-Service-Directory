/**
 * 
 */
package com.absd.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.absd.dao.GeographyDAO;
import com.absd.entity.Geography;
import com.absd.util.HibernateUtil;

@Repository
public class GeographyDAOlmpl implements GeographyDAO {

	public GeographyDAOlmpl() {
		System.out.println("GeographyDAOImpl");
	}

	@Autowired
	private HibernateUtil hibernateUtil;

	// Create new Geography object via hibernateUtil
	@Override
	public long createGeography(Geography geography) {
		return (Long) hibernateUtil.create(geography);
	}

	// Update Geography object via hibernateUtil
	@Override
	public Geography updateGeography(Geography geography) {
		return hibernateUtil.update(geography);
	}

	// Delete Geography object via hibernateUtil
	@Override
	public void deleteGeography(long id) {
		Geography geography = new Geography();
		geography.setId(id);
		hibernateUtil.delete(geography);
	}

	// Get all Geography object via hibernateUtil
	@Override
	public List<Geography> getAllGeographys() {
		return hibernateUtil.fetchAll(Geography.class);
	}

	// Get geography by ID
	@Override
	public Geography getGeography(long id) {
		return hibernateUtil.fetchById(id, Geography.class);
	}

	// Get data from Geography table in database to Geography object
	@SuppressWarnings("unchecked")
	@Override
	public List<Geography> getAllGeographys(String geographyName) {
		String query = "SELECT e.* FROM Geography e WHERE e.countryName like '%"
				+ geographyName + "%'";
		List<Object[]> geographyObjects = hibernateUtil.fetchAll(query);
		List<Geography> geographys = new ArrayList<Geography>();
		for (Object[] geographyObject : geographyObjects) {
			Geography geography = new Geography();

			long id = ((BigInteger) geographyObject[0]).longValue();
			String countryName = (String) geographyObject[1];
			String region = (String) geographyObject[2];
			String district = (String) geographyObject[3];
			String description = (String) geographyObject[4];

			geography.setId(id);
			geography.setCountryName(countryName);
			geography.setRegion(region);
			geography.setDistrict(district);
			geography.setDescription(description);

			geographys.add(geography);
		}
		System.out.println(geographys);
		return geographys;
	}
}