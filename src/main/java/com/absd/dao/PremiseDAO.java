/**
 * 
 */
package com.absd.dao;

import java.util.List;

import com.absd.entity.Premise;

// PremiseDAO interface
public interface PremiseDAO {
	public long createPremise(Premise premise);

	public Premise updatePremise(Premise premise);

	public void deletePremise(long id);

	public List<Premise> getAllPremises();

	public Premise getPremise(long id);

	public List<Premise> getAllPremises(String premiseName);
}
