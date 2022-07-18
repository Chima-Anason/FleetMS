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
import com.anagraceTech.FleetMS.parameters.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	//Fetch all countries
	@GetMapping("/countries")
	public String getAll(Model model) {
		
		List<Country> countries = countryService.getAll();
		
		model.addAttribute("countries", countries);
		
		return "parameters/countries";
	}
	
	
	//Go to Add page
	@GetMapping("/countryAdd")
	public String addCountry() {
		
		return "parameters/countryAdd";
	}
	
	//Save
	@PostMapping("/countries")
	public String save(Country country) {
		
		System.out.println(country);
		countryService.save(country);
		return "redirect:/countries";
	}
	
	
	
	//Delete
	@RequestMapping(value = "/countries/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		countryService.delete(id);
		
		return "redirect:/countries";
	}
	
	//Go to Edit page
	@GetMapping("/parameters/country/Edit/{id}")
	public String editCountry(@PathVariable Integer id, Model model) {
		Country country = countryService.getById(id);
		
		model.addAttribute("country", country);
		
		return "parameters/countryEdit";
	}
	
		
		
		
		//Go to Details page
		@GetMapping("/countryDetails/{id}")
		public String detailCountry(@PathVariable Integer id, Model model) {
			Country country = countryService.getById(id);
			
			model.addAttribute("country", country);
			
			return "parameters/countryDetails";
		}
		
		
		
		
	
	
}
