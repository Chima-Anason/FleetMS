package com.anagraceTech.FleetMS.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anagraceTech.FleetMS.parameters.models.Location;
import com.anagraceTech.FleetMS.parameters.services.CountryService;
import com.anagraceTech.FleetMS.parameters.services.LocationService;
import com.anagraceTech.FleetMS.parameters.services.StateService;

@Controller
public class LocationController {

	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private LocationService locationService;
	
	
	
	public Model addModelAttribute(Model model) {
		
		model.addAttribute("countries", countryService.getAll());
		model.addAttribute("states", stateService.getAll());
		model.addAttribute("locations", locationService.getAll());
		return model;
	}
	
	
	//Fetch all locations
	@GetMapping("/parameters/locations")
	public String getAll(Model model) {
		addModelAttribute(model);
		
		return "parameters/locations";
	}
	
	
	//Go to Add page
	@GetMapping("/parameters/locationAdd")
	public String addLocation(Model model) {
		model.addAttribute("countries", countryService.getAll());
		
		return "parameters/locationAdd";
	}
	
	//Save
	@PostMapping("/parameters/locations")
	public String save(Location location) {
		
		System.out.println(location);
		locationService.save(location);
		return "redirect:/parameters/locations";
	}
	
	
	
	//Delete
	@RequestMapping(value = "/parameters/location/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		locationService.delete(id);
		
		return "redirect:/parameters/locations";
	}
	
	//Go to Edit page
	@GetMapping("/parameters/location/{op}/{id}")
	public String editState(@PathVariable Integer id, @PathVariable String op, Model model) {
		addModelAttribute(model);
		Location location = locationService.getById(id);
		
		model.addAttribute("location", location);
		
		return "parameters/location" + op;
	}
	
		
		
		
		
	
	
}
