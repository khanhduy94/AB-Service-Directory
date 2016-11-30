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

import com.absd.dao.OrganisationDAO;
import com.absd.entity.Organisation;

@ContextConfiguration(locations = "classpath:mvc-dispatcher-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrganisationDAOTest {
	@Autowired
	private OrganisationDAO organisationDAO;

	// Test create a new Organization
	@Test
	@Transactional
	@Rollback(true)
	public void testCreateOrganisation() {
		Organisation organisation = new Organisation("1", "UT_address",
				"UT_postCode", 12456789, "UT_email@gmail.com");
		organisationDAO.createOrganisation(organisation);
		long tempId = organisation.getId();
		List<Organisation> organisations = organisationDAO
				.getAllOrganisations();
		Assert.assertEquals(tempId, organisations.get(organisations.size() - 1)
				.getId());
	}

	// Test update a Organization in database
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateOrganisation() {
		Organisation organisation = new Organisation("UT_name", "UT_address",
				"UT_postCode", 12456789, "UT_email@gmail.com");
		organisation.setId(1);
		Organisation organisationBefore = organisation;
		organisationDAO.updateOrganisation(organisation);
		Organisation organisationAfter = organisationDAO
				.getOrganisation(organisationBefore.getId());

		Assert.assertEquals(organisationBefore, organisationAfter);
	}

	// Test delete Organization in database
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteOrganisation() {
		organisationDAO.deleteOrganisation(13);
		Assert.assertNull(organisationDAO.getOrganisation(13));
	}

	// Test get all organizations in database
	@Test
	@Transactional
	@Rollback(true)
	public void testGetAllOrganisations() {
		int numberOfRecord = 0;
		numberOfRecord = organisationDAO.getAllOrganisations().size();
		Assert.assertNotEquals(0, numberOfRecord);
	}

	// Test get Organization in database for id
	@Test
	@Transactional
	@Rollback(true)
	public void testGetOrganisation() {
		Organisation Organisation = null;
		Organisation = organisationDAO.getAllOrganisations().get(0);
		Assert.assertNotNull(Organisation);
	}

	// Test get Organization in database for Name
	@Test
	@Transactional
	@Rollback(true)
	public void testGetAllOrganisationsString() {
		Organisation tempOrganisation = organisationDAO.getAllOrganisations()
				.get(0);
		String tempName = tempOrganisation.getOrgName();
		List<Organisation> Organisations = organisationDAO
				.getAllOrganisations(tempName);
		Boolean exist = false;
		for (Organisation Organisation : Organisations) {
			if (Organisation.getOrgName().equals(tempName))
				exist = true;
		}
		Assert.assertTrue(exist);
	}
}
