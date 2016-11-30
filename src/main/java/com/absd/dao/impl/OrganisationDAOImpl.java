/**
 * class OrganizationDAOImpl
 */

package com.absd.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.absd.dao.OrganisationDAO;
import com.absd.entity.Organisation;
import com.absd.util.HibernateUtil;

/**
 * @author ToanNX
 * @version 1.0
 */

@Repository
public class OrganisationDAOImpl implements OrganisationDAO {
    
	public OrganisationDAOImpl() {
    	System.out.println("OrganisationDAOImpl");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

	// create a new Organization by hibernate
    @Override
    public long createOrganisation(Organisation organisation) {        
        return (Long) hibernateUtil.create(organisation);
    }
    
    // update a Organization in database by hibernate
    @Override
    public Organisation updateOrganisation(Organisation organisation) {        
        return hibernateUtil.update(organisation);
    }
    
    // delete a Organization in database by hibernate
    @Override
    public void deleteOrganisation(long id) {
        Organisation organisation = new Organisation();
        organisation.setId(id);
        hibernateUtil.delete(organisation);
    }
    
    // get all list Organizations in database by hibernate
    @Override
    public List<Organisation> getAllOrganisations() {        
        return hibernateUtil.fetchAll(Organisation.class);
    }
    
    // get Organization in database for id by hibernate
    @Override
    public Organisation getOrganisation(long id) {
        return hibernateUtil.fetchById(id, Organisation.class);
    }

    // get Organizations in database for Name by hibernate
	@SuppressWarnings("unchecked")
	@Override
	public List<Organisation> getAllOrganisations(String organisationName) { 
		String query = "SELECT e.* FROM Organisation e WHERE e.orgName like '%"+ organisationName +"%'";
		List<Object[]> organisationObjects = hibernateUtil.fetchAll(query);
		List<Organisation> organisations = new ArrayList<Organisation>();
		for(Object[] organisationObject: organisationObjects) {
			Organisation organisation = new Organisation();
			
			long id = ((BigInteger) organisationObject[0]).longValue();			
			String orgName = (String) organisationObject[1];
			String address = (String) organisationObject[2];
			String postCode = (String) organisationObject[3];
			int phone = (int) organisationObject[4];
			String email = (String) organisationObject[5];
			
			organisation.setId(id);
			organisation.setOrgName(orgName);
			organisation.setAddress(address);
			organisation.setPostCode(postCode);
			organisation.setPhone(phone);
			organisation.setEmail(email);
			
			organisations.add(organisation);
		}
		System.out.println(organisations);
		return organisations;
	}
}