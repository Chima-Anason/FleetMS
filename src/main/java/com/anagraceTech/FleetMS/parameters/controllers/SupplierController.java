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

import com.anagraceTech.FleetMS.parameters.models.Supplier;
import com.anagraceTech.FleetMS.parameters.services.CountryService;
import com.anagraceTech.FleetMS.parameters.services.StateService;
import com.anagraceTech.FleetMS.parameters.services.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private SupplierService supplierService;
	
	
	
	public Model addModelAttribute(Model model) {
		
		model.addAttribute("countries", countryService.getAll());
		model.addAttribute("states", stateService.getAll());
		model.addAttribute("suppliers", supplierService.getAll());
		return model;
	}
	
	
	//Fetch all 
	@GetMapping("/parameters/suppliers")
	public String getAll(Model model, String keyword) {
		
		List<Supplier> suppliers;
		if(keyword==null) {
			suppliers = supplierService.getAll();
		}else {
			suppliers = supplierService.findByKeyword(keyword);
		}

		model.addAttribute("suppliers", suppliers);
		model.addAttribute("searchAction", "/parameters/suppliers");
		
		return "parameters/suppliers";
	}
	
	
	//Go to Add page
	@GetMapping("/parameters/supplierAdd")
	public String addLocation(Model model) {
		model.addAttribute("countries", countryService.getAll());
		
		return "parameters/supplierAdd";
	}
	
	//Save
	@PostMapping("/parameters/suppliers")
	public String save(Supplier supplier) {
		
		System.out.println(supplier);
		supplierService.save(supplier);
		return "redirect:/parameters/suppliers";
	}
	
	
	
	//Delete
	@RequestMapping(value = "/parameters/supplier/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		supplierService.delete(id);
		
		return "redirect:/parameters/suppliers";
	}
	
	//Go to Edit page
	@GetMapping("/parameters/supplier/{op}/{id}")
	public String edit(@PathVariable Integer id, @PathVariable String op, Model model) {
		addModelAttribute(model);
		Supplier supplier = supplierService.getById(id);
		
		model.addAttribute("supplier", supplier);
		
		return "parameters/supplier" + op;
	}
	
		
		
		
		
	
	
}
