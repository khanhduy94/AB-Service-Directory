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

import com.absd.dao.PremiseDAO;
import com.absd.entity.Premise;

// Load the test configuration file before starting test-suite:
@ContextConfiguration(locations = "classpath:mvc-dispatcher-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PremiseDAOTest {
	// inject DAO references directly into test case:
	@Autowired
	private PremiseDAO premiseDAO;

	// The test case:
	@Test
	@Transactional
	// This is a transaction
	@Rollback(true)
	// and this annotation to bring back original database state
	public void testCreatePremise() {
		// Create premise and add to database:
		Premise premise = new Premise("UT_name", "UT_address", "UT_postCode",
				12456789, "UT_email@gmail.com");
		premiseDAO.createPremise(premise);
		long tempId = premise.getId();
		// Get all premise from database:
		List<Premise> premises = premiseDAO.getAllPremises();
		// Check they are equal numbers:
		Assert.assertEquals(tempId, premises.get(premises.size() - 1).getId());
	}

	// The test case:
	@Test
	@Transactional
	// This is a transaction
	@Rollback(true)
	// and this annotation to bring back original database state
	public void testUpdatePremise() {
		// Create new database
		Premise premise = new Premise("UT_name", "UT_address", "UT_postCode",
				12456789, "UT_email@gmail.com");
		premise.setId(1);
		Premise beforePremise = premise;
		// Update premise to database:
		premiseDAO.updatePremise(premise);
		// Get premise after update:
		Premise afterPremise = premiseDAO.getPremise(beforePremise.getId());
		// Check they are not same:
		Assert.assertEquals(beforePremise, afterPremise);
	}

	// The test case:
	@Test
	@Transactional
	// This is a transaction
	@Rollback(true)
	// and this annotation to bring back original database state
	public void testDeletePremise() {
		// Delete this premise:
		premiseDAO.deletePremise(13);
		// Then get it and check it is null:
		Assert.assertNull(premiseDAO.getPremise(13));
	}

	// The test case:
	@Test
	@Transactional
	// This is a transaction
	@Rollback(true)
	// and this annotation to bring back original database state
	public void testGetAllPremises() {
		int numberOfRecord = 0;
		// Get number of premises in database:
		numberOfRecord = premiseDAO.getAllPremises().size();
		// And check it is not equal 0:
		Assert.assertNotEquals(0, numberOfRecord);
	}

	// The test case:
	@Test
	@Transactional
	// This is a transaction
	@Rollback(true)
	// and this annotation to bring back original database state
	public void testGetPremise() {
		// Set premise is null:
		Premise premise = null;
		// Get it from database:
		premise = premiseDAO.getAllPremises().get(0);
		// And check it is not null:
		Assert.assertNotNull(premise);
	}

	// The test case:
	@Test
	@Transactional
	// This is a transaction
	@Rollback(true)
	// and this annotation to bring back original database state
	public void testGetAllPremisesString() {
		// Get the first premise from database:
		Premise tempPremise = premiseDAO.getAllPremises().get(0);
		// Get its name:
		String tempName = tempPremise.getPreName();
		// Search premises by this name:
		List<Premise> premises = premiseDAO.getAllPremises(tempName);
		Boolean exist = false;
		// Check the result is include the before name:
		for (Premise premise : premises) {
			if (premise.getPreName().equals(tempName))
				exist = true;
		}

		Assert.assertTrue(exist);
	}

}
