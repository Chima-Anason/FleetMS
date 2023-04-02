package com.anagraceTech.FleetMS.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anagraceTech.FleetMS.parameters.models.Client;
import com.anagraceTech.FleetMS.parameters.services.ClientService;
import com.anagraceTech.FleetMS.parameters.services.CountryService;
import com.anagraceTech.FleetMS.parameters.services.StateService;

@Controller
public class ClientController {

	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private ClientService clientService;
	
	
	
	public Model addModelAttribute(Model model) {
		
		model.addAttribute("countries", countryService.getAll());
		model.addAttribute("states", stateService.getAll());
		model.addAttribute("clients", clientService.getAll());
		return model;
	}
	
	
	//Fetch all 
	@GetMapping("/parameters/clients")
	public String getAll(Model model) {
		addModelAttribute(model);
		
		return "parameters/clients";
	}
	
	
	//Go to Add page
	@GetMapping("/parameters/clientAdd")
	public String addLocation(Model model) {
		model.addAttribute("countries", countryService.getAll());
		
		return "parameters/clientAdd";
	}
	
	//Save
	@PostMapping("/parameters/clients")
	public String save(Client client) {
		
		System.out.println(client);
		clientService.save(client);
		return "redirect:/parameters/clients";
	}
	
	
	
	//Delete
	@RequestMapping(value = "/parameters/client/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		clientService.delete(id);
		
		return "redirect:/parameters/clients";
	}
	
	//Go to Edit page
	@GetMapping("/parameters/client/{op}/{id}")
	public String edit(@PathVariable Integer id, @PathVariable String op, Model model) {
		addModelAttribute(model);
		Client client = clientService.getById(id);
		
		model.addAttribute("client", client);
		
		return "parameters/client" + op;
	}
	
		
		
		
		
	
	
}
