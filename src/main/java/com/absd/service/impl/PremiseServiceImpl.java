package com.absd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.absd.dao.PremiseDAO;
import com.absd.entity.Premise;
import com.absd.service.PremiseService;

// Declare Service layer of Spring
@Service
@Transactional
public class PremiseServiceImpl implements PremiseService {

	// Use PremiseDAO Object
	@Autowired
	private PremiseDAO premiseDAO;

	// Create premise
	@Override
	public long createPremise(Premise premise) {
		return premiseDAO.createPremise(premise);
	}

	// Update premise
	@Override
	public Premise updatePremise(Premise premise) {
		return premiseDAO.updatePremise(premise);
	}

	// Delete premise
	@Override
	public void deletePremise(long id) {
		premiseDAO.deletePremise(id);
	}

	// Get all premises
	@Override
	public List<Premise> getAllPremises() {
		return premiseDAO.getAllPremises();
	}

	// Get premise by id
	@Override
	public Premise getPremise(long id) {
		return premiseDAO.getPremise(id);
	}

	// Search premise by name
	@Override
	public List<Premise> getAllPremises(String premiseName) {
		return premiseDAO.getAllPremises(premiseName);
	}
}
