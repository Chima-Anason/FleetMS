package com.anagraceTech.FleetMS.parameters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anagraceTech.FleetMS.parameters.models.Country;
import com.anagraceTech.FleetMS.parameters.models.State;
import com.anagraceTech.FleetMS.parameters.services.CountryService;
import com.anagraceTech.FleetMS.parameters.services.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	
	
	public Model addModelAttribute(Model model) {
		
		List<State> states = stateService.getAll();
		List<Country> countries = countryService.getAll();
		model.addAttribute("countries", countries);
		model.addAttribute("states", states);	
		return model;
	}
	
	
	//Fetch all
	@GetMapping("/parameters/states")
	public String getAll(Model model, String keyword) {
		
		List<State> states = stateService.getAll();
		
		if(keyword==null) {
			addModelAttribute(model);
		}else {
			states = stateService.findByKeyword(keyword);
		}
		
		model.addAttribute("states", states);
		model.addAttribute("searchAction", "/parameters/states");
		
		return "parameters/states";
	}
	
	
	//Go to Add page
	@GetMapping("/parameters/stateAdd")
	public String addPage(Model model) {
		addModelAttribute(model);
		
		return "parameters/stateAdd";
	}
	
	//Save
	@PostMapping("/parameters/states")
	public String save(State state) {
		
		System.out.println(state);
		stateService.save(state);
		return "redirect:/parameters/states";
	}
	
	
	
	//Delete
	@RequestMapping(value = "/parameters/state/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		stateService.delete(id);
		
		return "redirect:/parameters/states";
	}
	
	//Go to Edit/Detail page
	@GetMapping("/parameters/state/{op}/{id}")
	public String editAndDetails(@PathVariable Integer id, @PathVariable String op, Model model) {
		addModelAttribute(model);
		State state = stateService.getById(id);
		
		model.addAttribute("state", state);
		
		return "parameters/state" + op;
	}
	
		
		
		
		
	
	
}
