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
	
	
	//Fetch all
	@GetMapping("/parameters/locations")
	public String getAll(Model model, String keyword) {
		
		List<Location> locations = locationService.getAll();
		if(keyword == null) {
			addModelAttribute(model);
		}else {
			locations = locationService.findByKeyword(keyword);
		}
		
		model.addAttribute("locations", locations);
		model.addAttribute("searchAction", "/parameters/locations");
		
		return "parameters/locations";
	}
	
	
	//Go to Add page
	@GetMapping("/parameters/locationAdd")
	public String addPage(Model model) {
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
	
	//Go to Edit/Details page
	@GetMapping("/parameters/location/{op}/{id}")
	public String editAndDetails(@PathVariable Integer id, @PathVariable String op, Model model) {
		addModelAttribute(model);
		Location location = locationService.getById(id);
		
		model.addAttribute("location", location);
		
		return "parameters/location" + op;
	}
	
		
		
		
		
	
	
}
