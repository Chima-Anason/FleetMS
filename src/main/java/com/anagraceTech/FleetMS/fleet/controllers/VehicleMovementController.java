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

import com.anagraceTech.FleetMS.fleet.models.VehicleMovement;
import com.anagraceTech.FleetMS.fleet.services.VehicleMovementService;
import com.anagraceTech.FleetMS.fleet.services.VehicleService;
import com.anagraceTech.FleetMS.parameters.services.LocationService;

@Controller
public class VehicleMovementController {

	@Autowired
	private VehicleMovementService vehicleMovementService;
	@Autowired private LocationService locationService ;
	@Autowired private VehicleService vehicleService ;
	
	
	
	
	
	public Model addModelAttributes(Model model){
		model.addAttribute("vehicleMovements", vehicleMovementService.getAll());
		model.addAttribute("vehicles", vehicleService.getAll());
		model.addAttribute("locations1", locationService.getAll());
		model.addAttribute("locations2", locationService.getAll());

		return model;
	}
	
	
	//Fetch all
	@GetMapping("/fleet/vehicleMovements")
	public String getAll(Model model, String keyword) {
		
		List<VehicleMovement> vehicleMovements;
		
		if(keyword==null) {
			vehicleMovements = vehicleMovementService.getAll();
		}else {
			vehicleMovements = vehicleMovementService.findByKeyword(keyword);
		}
		
		model.addAttribute("vehicleMovements", vehicleMovements);
		model.addAttribute("searchAction", "/fleet/vehicleMovements");
		
		return "fleet/vehicleMovements";
	}
	
	
	//Go to Add page
	@GetMapping("/fleet/vehicleMovementAdd")
	public String addPage(Model model) {
		addModelAttributes(model);

		return "fleet/vehicleMovementAdd";
	}
	
	//Save
	@PostMapping("/fleet/vehicleMovements")
	public String save(VehicleMovement vehicleMovement) {
		
		System.out.println(vehicleMovement);
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/fleet/vehicleMovements";
	}
	
	
	
	//Delete
	@RequestMapping(value = "/fleet/vehicleMovement/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		vehicleMovementService.delete(id);
		
		return "redirect:/fleet/vehicleMovements";
	}
	
	//Go to Edit/Detail page
	@GetMapping("/fleet/vehicleMovement/{op}/{id}")
	public String editAndDetails(@PathVariable Integer id, @PathVariable String op, Model model) {
		addModelAttributes(model);
		VehicleMovement vehicleMovement = vehicleMovementService.getById(id);
		
		model.addAttribute("vehicleMovement", vehicleMovement);
		
		return "fleet/vehicleMovement" + op;
	}
	
		
		
		
		
	
	
}
