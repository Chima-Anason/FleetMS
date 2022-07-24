package com.anagraceTech.FleetMS.fleet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anagraceTech.FleetMS.fleet.models.VehicleHire;
import com.anagraceTech.FleetMS.fleet.services.VehicleHireService;
import com.anagraceTech.FleetMS.fleet.services.VehicleService;
import com.anagraceTech.FleetMS.parameters.services.ClientService;
import com.anagraceTech.FleetMS.parameters.services.LocationService;

@Controller
public class VehicleHireController {

	@Autowired
	private VehicleHireService vehicleHireService;
	@Autowired private ClientService clientService;
	@Autowired private LocationService locationService;
	@Autowired private VehicleService vehicleService;
	
	
	public Model addModelAttributes(Model model){
		model.addAttribute("clients", clientService.getAll());
		model.addAttribute("locations", locationService.getAll());
		model.addAttribute("vehicles", vehicleService.getAll());
		return model;
	}
	


	//Fetch all
	@GetMapping("/fleet/vehicleHires")
	public String getAll(Model model, String keyword) {
		
		List<VehicleHire> vehicleHires = vehicleHireService.getAll();
		
		if(keyword==null) {
			addModelAttributes(model);
		}else {
			vehicleHires = vehicleHireService.findByKeyword(keyword);
		}
		
		model.addAttribute("vehicleHires", vehicleHires);
		model.addAttribute("searchAction", "/fleet/vehicleHires");
		
		return "fleet/vehicleHires";
	}
	
	
	//Go to Add page
	@GetMapping("/fleet/vehicleHireAdd")
	public String addPage(Model model) {
		addModelAttributes(model);
		
		return "fleet/vehicleHireAdd";
	}
	
	//Save
	@PostMapping("/fleet/vehicleHires")
	public String save(VehicleHire vehicleHire) {
		
		System.out.println(vehicleHire);
		vehicleHireService.save(vehicleHire);
		return "redirect:/fleet/vehicleHires";
	}
	
	
	
	//Delete
	@RequestMapping(value = "/fleet/vehicleHire/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		vehicleHireService.delete(id);
		
		return "redirect:/fleet/vehicleHires";
	}
	
	//Go to Edit/Detail page
	@GetMapping("/fleet/vehicleHire/{op}/{id}")
	public String editAndDetails(@PathVariable Integer id, @PathVariable String op, Model model) {
		addModelAttributes(model);
		VehicleHire vehicleHire = vehicleHireService.getById(id);
		
		model.addAttribute("vehicleHire", vehicleHire);
		
		return "fleet/vehicleHire" + op;
	}
	
		
		
		
		
	
	
}
