/**
 * class OrganizationController
 */

package com.absd.controller;

import com.absd.entity.Organisation;
import com.absd.service.OrganisationService;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ToanNX
 * @version 1.0
 */

@Controller
public class OrganisationController {

	private static final Logger logger = Logger
			.getLogger(OrganisationController.class);

	public OrganisationController() {
		System.out.println("OrganisationController()");
	}

	@Autowired
	private OrganisationService organisationService;

	// create Organization
	@RequestMapping("createOrganisation")
	public ModelAndView createOrganisation(
			@ModelAttribute Organisation organisation) {
		logger.info("Creating organisation. Data: " + organisation);
		return new ModelAndView("organisationForm");
	}

	// update Organization
	@RequestMapping("editOrganisation")
	public ModelAndView editOrganisation(@RequestParam long id,
			@ModelAttribute Organisation organisation) {
		logger.info("Updating the organisation for the Id " + id);
		organisation = organisationService.getOrganisation(id);
		return new ModelAndView("organisationForm", "organisationObject",
				organisation);
	}

	// save Organization
	@RequestMapping("saveOrganisation")
	public ModelAndView saveOrganisation(
			@ModelAttribute Organisation organisation) {
		logger.info("Saving the organisation. Data : " + organisation);

		// if organization id is 0 then creating the organization other updating
		// the organization
		if (organisation.getId() == 0) {
			organisationService.createOrganisation(organisation);
		} else {
			organisationService.updateOrganisation(organisation);
		}
		return new ModelAndView("redirect:getAllOrganisations");
	}

	// delete Organization
	@RequestMapping("deleteOrganisation")
	public ModelAndView deleteOrganisation(@RequestParam long id) {
		logger.info("Deleting the organisation. Id : " + id);
		organisationService.deleteOrganisation(id);
		return new ModelAndView("redirect:getAllOrganisations");
	}

	@RequestMapping(value = { "/" })
	public ModelAndView home() {
		logger.info("Getting the all organisations.");
		return new ModelAndView("index");
	}

	// get and view Organization
	@RequestMapping(value = { "getAllOrganisations" })
	public ModelAndView getAllOrganisations() {
		logger.info("Getting the all organisations.");
		List<Organisation> organisationList = organisationService
				.getAllOrganisations();
		return new ModelAndView("organisationList", "organisationList",
				organisationList);
	}

	// search Organization
	@RequestMapping("searchOrganisation")
	public ModelAndView searchOrganisation(
			@RequestParam("searchName") String searchName) {
		logger.info("Searching the organisation. Organisation Names: "
				+ searchName);
		List<Organisation> organisationList = organisationService
				.getAllOrganisations(searchName);
		return new ModelAndView("organisationList", "organisationList",
				organisationList);
	}
}