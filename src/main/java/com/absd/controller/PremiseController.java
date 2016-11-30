package com.absd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.absd.entity.Premise;
import com.absd.service.PremiseService;

// Declare Controller of MVC

@Controller
public class PremiseController {

	// private static final Logger logger =
	// Logger.getLogger(PremiseController.class);

	public PremiseController() {
		System.out.println("Class PremiseController()");
	}

	// Use PremiseService object
	@Autowired
	private PremiseService premiseService;

	// Create premise
	@RequestMapping("createPremise")
	public ModelAndView createPremise(@ModelAttribute Premise premise) {
		return new ModelAndView("premiseForm");
	}

	// Redirect to premiseFrom page for edit premise
	@RequestMapping("editPremise")
	public ModelAndView editPremise(@RequestParam long id,
			@ModelAttribute Premise premise) {
		premise = premiseService.getPremise(id);
		return new ModelAndView("premiseForm", "premiseObject", premise);
	}

	// Save premise and redirect to premise list
	@RequestMapping("savePremise")
	public ModelAndView savePremise(@ModelAttribute Premise premise) {
		if (premise.getId() == 0) {
			premiseService.createPremise(premise);
		} else {
			premiseService.updatePremise(premise);
		}
		return new ModelAndView("redirect:getAllPremises");
	}

	// Delete premise
	@RequestMapping("deletePremise")
	public ModelAndView deletePremise(@RequestParam long id) {
		premiseService.deletePremise(id);
		return new ModelAndView("redirect:getAllPremises");
	}

	// Get and view all premises
	@RequestMapping(value = { "getAllPremises" })
	public ModelAndView getAllPremises() {
		List<Premise> premiseList = premiseService.getAllPremises();
		return new ModelAndView("premiseList", "premiseList", premiseList);
	}

	// Search premise by name
	@RequestMapping("searchPremise")
	public ModelAndView searchPremise(
			@RequestParam("searchName") String searchName) {
		List<Premise> premiseList = premiseService.getAllPremises(searchName);
		return new ModelAndView("premiseList", "premiseList", premiseList);
	}
}