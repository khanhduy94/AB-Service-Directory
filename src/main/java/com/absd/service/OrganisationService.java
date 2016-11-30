/**
 * class OrganizationService
 */

package com.absd.service;

import java.util.List;

import com.absd.entity.Organisation;

/**
 * @author ToanNX
 * @version 1.0
 */
public interface OrganisationService {
	// create a new Organization
	public long createOrganisation(Organisation organisation);

	// update information of Organization in database
	public Organisation updateOrganisation(Organisation organisation);

	// delete a Organization in database
	public void deleteOrganisation(long id);

	// get all list Organizations in database
	public List<Organisation> getAllOrganisations();

	// get Organization in database for Id
	public Organisation getOrganisation(long id);

	// get Organizations in database for Name
	public List<Organisation> getAllOrganisations(String organisationName);
}
