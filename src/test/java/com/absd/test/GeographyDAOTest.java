package com.absd.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.absd.dao.GeographyDAO;
import com.absd.entity.Geography;

@ContextConfiguration(locations = "classpath:mvc-dispatcher-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GeographyDAOTest {
	@Autowired
	private GeographyDAO geographyDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void testCreateGeography() {
		Geography geography = new Geography("UT_countryName", "UT_region",
				"UT_district", "UT_description");
		geographyDAO.createGeography(geography);
		long tempId = geography.getId();
		List<Geography> geographys = geographyDAO.getAllGeographys();
		Assert.assertEquals(tempId, geographys.get(geographys.size() - 1)
				.getId());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateGeography() {
		Geography geography = new Geography("UT_countryName", "UT_region",
				"UT_district", "UT_description");
		geography.setId(1);
		Geography geographyBefore = geography;
		geographyDAO.updateGeography(geography);
		Geography geographyAfter = geographyDAO.getGeography(geographyBefore
				.getId());

		Assert.assertEquals(geographyBefore, geographyAfter);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteGeography() {
		geographyDAO.deleteGeography(13);
		Assert.assertNull(geographyDAO.getGeography(13));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetAllGeographys() {
		int numberOfRecord = 0;
		numberOfRecord = geographyDAO.getAllGeographys().size();
		Assert.assertNotEquals(0, numberOfRecord);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetGeography() {
		Geography Geography = null;
		Geography = geographyDAO.getAllGeographys().get(0);
		Assert.assertNotNull(Geography);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetAllGeographysString() {
		Geography tempGeography = geographyDAO.getAllGeographys().get(0);
		String tempName = tempGeography.getCountryName();
		List<Geography> Geographys = geographyDAO.getAllGeographys(tempName);
		Boolean exist = false;
		for (Geography Geography : Geographys) {
			if (Geography.getCountryName().equals(tempName))
				exist = true;
		}
		Assert.assertTrue(exist);
	}
}
