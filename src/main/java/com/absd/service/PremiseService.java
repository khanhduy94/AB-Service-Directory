package com.absd.service;

import java.util.List;

import com.absd.entity.Premise;

// PremiseService interface
public interface PremiseService {
	public long createPremise(Premise premise);

	public Premise updatePremise(Premise premise);

	public void deletePremise(long id);

	public List<Premise> getAllPremises();

	public Premise getPremise(long id);

	public List<Premise> getAllPremises(String premiseName);
}
