package com.absd.controller;

import com.absd.entity.Geography;
import com.absd.service.GeographyService;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author DuyDT
 * @version 1.0
 */
@Controller
public class GeographyController {

	private static final Logger logger = Logger
			.getLogger(GeographyController.class);

	public GeographyController() {
		System.out.println("GeographyController()");
	}

	@Autowired
	private GeographyService geographyService;

	@RequestMapping("createGeography")
	public ModelAndView createGeography(@ModelAttribute Geography geography) {
		logger.info("Creating geography. Data: " + geography);
		return new ModelAndView("geographyForm");
	}

	@RequestMapping("editGeography")
	public ModelAndView editGeography(@RequestParam long id,
			@ModelAttribute Geography geography) {
		logger.info("Updating the geography for the Id " + id);
		geography = geographyService.getGeography(id);
		return new ModelAndView("geographyForm", "geographyObject", geography);
	}

	@RequestMapping("saveGeography")
	public ModelAndView saveGeography(@ModelAttribute Geography geography) {
		logger.info("Saving the geography. Data : " + geography);
		if (geography.getId() == 0) { // if geography id is 0 then creating the
										// geography other updating the
										// geography
			geographyService.createGeography(geography);
		} else {
			geographyService.updateGeography(geography);
		}
		return new ModelAndView("redirect:getAllGeographys");
	}

	@RequestMapping("deleteGeography")
	public ModelAndView deleteGeography(@RequestParam long id) {
		logger.info("Deleting the geography. Id : " + id);
		geographyService.deleteGeography(id);
		return new ModelAndView("redirect:getAllGeographys");
	}

	@RequestMapping(value = { "getAllGeographys" })
	public ModelAndView getAllGeographys() {
		logger.info("Getting the all geographys.");
		List<Geography> geographyList = geographyService.getAllGeographys();
		return new ModelAndView("geographyList", "geographyList", geographyList);
	}

	@RequestMapping("searchGeography")
	public ModelAndView searchGeography(
			@RequestParam("searchName") String searchName) {
		logger.info("Searching the geography. Geography Names: " + searchName);
		List<Geography> geographyList = geographyService
				.getAllGeographys(searchName);
		return new ModelAndView("geographyList", "geographyList", geographyList);
	}
}