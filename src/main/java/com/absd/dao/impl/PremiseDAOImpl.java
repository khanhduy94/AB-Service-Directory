package com.absd.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.absd.dao.PremiseDAO;
import com.absd.entity.Premise;
import com.absd.util.HibernateUtil;

// This class implements PremiseDAO class
@Repository
public class PremiseDAOImpl implements PremiseDAO {

	public PremiseDAOImpl() {
		System.out.println("Class PremiseDAO");
	}

	// Use object of HibernateUtil class
	@Autowired
	private HibernateUtil hibernateUtil;

	// Create Premise method
	@Override
	public long createPremise(Premise premise) {
		return (Long) hibernateUtil.create(premise);
	}

	// Update Premise method
	@Override
	public Premise updatePremise(Premise premise) {
		return hibernateUtil.update(premise);
	}

	// Delete Premise method
	@Override
	public void deletePremise(long id) {
		Premise premise = new Premise();
		premise.setId(id);
		hibernateUtil.delete(premise);
	}

	// Get all Premises method
	@Override
	public List<Premise> getAllPremises() {
		return hibernateUtil.fetchAll(Premise.class);
	}

	// Get Premise by id method
	@Override
	public Premise getPremise(long id) {
		return hibernateUtil.fetchById(id, Premise.class);
	}

	// Search Premises by name method
	@SuppressWarnings("unchecked")
	@Override
	public List<Premise> getAllPremises(String premiseName) {
		String query = "SELECT p.* FROM Premise p WHERE p.preName LIKE '%"
				+ premiseName + "%'";

		// Get Premises from database and save to Object list
		List<Object[]> premiseObjects = hibernateUtil.fetchAll(query);
		List<Premise> premises = new ArrayList<Premise>();
		// Get premises value from Object list
		for (Object[] premiseObject : premiseObjects) {
			Premise premise = new Premise();
			premise.setId(((BigInteger) premiseObject[0]).longValue());
			premise.setPreName((String) premiseObject[1]);
			premise.setAddress((String) premiseObject[2]);
			premise.setPostCode((String) premiseObject[3]);
			premise.setPhone((Integer) premiseObject[4]);
			premise.setEmail((String) premiseObject[5]);
			premises.add(premise);
		}
		return premises;
	}
}