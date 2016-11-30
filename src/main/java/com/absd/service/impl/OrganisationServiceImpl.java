/**
 * class OrganizationServiceImpl
 */

package com.absd.service.impl;

import com.absd.dao.OrganisationDAO;
import com.absd.entity.Organisation;
import com.absd.service.OrganisationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author ToanNX
 * @version 1.0
 */
@Service
@Transactional
public class OrganisationServiceImpl implements OrganisationService {
	
	public OrganisationServiceImpl() {
		System.out.println("OrganisationServiceImpl()");
	}
	
    @Autowired
    private OrganisationDAO organisationDAO;

    // create a new Organization
    @Override
    public long createOrganisation(Organisation organisation) {
        return organisationDAO.createOrganisation(organisation);
    }
    
    // create a new Organization
    @Override
    public Organisation updateOrganisation(Organisation organisation) {
        return organisationDAO.updateOrganisation(organisation);
    }
    
    // delete a Organization in database
    @Override
    public void deleteOrganisation(long id) {
        organisationDAO.deleteOrganisation(id);
    }
    
    // get all list Organizations in database
    @Override
    public List<Organisation> getAllOrganisations() {
        return organisationDAO.getAllOrganisations();
    }
    
    // get Organization in database for Id
    @Override
    public Organisation getOrganisation(long id) {
        return organisationDAO.getOrganisation(id);
    }    
    
    // get Organizations in database for Name
    @Override
    public List<Organisation> getAllOrganisations(String organisationName) {
    	return organisationDAO.getAllOrganisations(organisationName);
    }
}
