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
import org.springframework.web.bind.annotation.ResponseBody;

import com.anagraceTech.FleetMS.parameters.models.Country;
import com.anagraceTech.FleetMS.parameters.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	// Fetch all countries
	@GetMapping("/parameters/countries")
	public String getAll(Model model, String keyword) {

		List<Country> countries;
		
		if(keyword==null) {
			countries = countryService.getAll();
		}else {
			countries = countryService.findByKeyword(keyword);
		}

		model.addAttribute("countries", countries);
		model.addAttribute("searchAction", "/parameters/countries");

		return "parameters/countries";
	}

	// Get Country By Id
	@GetMapping("/parameters/country/{id}")
	@ResponseBody
	public Country getById(@PathVariable Integer id) {
		return countryService.getById(id);
	}

	// Go to Add page
	@GetMapping("/parameters/countryAdd")
	public String addPage() {

		return "parameters/countryAdd";
	}

	// Save
	@PostMapping("/parameters/countries")
	public String save(Country country) {

		System.out.println(country);
		countryService.save(country);
		return "redirect:/parameters/countries";
	}

	// Delete
	@RequestMapping(value = "/parameters/countries/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		countryService.delete(id);

		return "redirect:/parameters/countries";
	}

	// Go to Edit and Details page
	@GetMapping("/parameters/country/{op}/{id}")
	public String editAndDetails(@PathVariable Integer id,@PathVariable String op, Model model) {
		Country country = countryService.getById(id);

		model.addAttribute("country", country);

		return "parameters/country" + op;
	}


}
