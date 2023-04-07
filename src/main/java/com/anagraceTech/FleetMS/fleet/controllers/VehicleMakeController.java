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
import org.springframework.web.bind.annotation.ResponseBody;

import com.anagraceTech.FleetMS.fleet.models.VehicleMake;
import com.anagraceTech.FleetMS.fleet.services.VehicleMakeService;

@Controller
public class VehicleMakeController {

	@Autowired
	private VehicleMakeService vehicleMakeService;

	// Fetch all 
	@GetMapping("/fleet/vehicleMakes")
	public String getAll(Model model, String keyword) {

		List<VehicleMake> vehicleMakes;
		
		if(keyword==null) {
			vehicleMakes = vehicleMakeService.getAll();
		}else {
			vehicleMakes = vehicleMakeService.findByKeyword(keyword);
		}

		model.addAttribute("vehicleMakes", vehicleMakes);
		model.addAttribute("searchAction", "/fleet/vehicleMakes");

		return "fleet/vehicleMakes";
	}

	// Get By Id
	@GetMapping("/fleet/vehicleMake/{id}")
	@ResponseBody
	public VehicleMake getById(@PathVariable Integer id) {
		return vehicleMakeService.getById(id);
	}


	// Save
	@PostMapping("/fleet/vehicleMakes")
	public String save(VehicleMake vehicleMake) {

		System.out.println(vehicleMake);
		vehicleMakeService.save(vehicleMake);
		return "redirect:/fleet/vehicleMakes";
	}

	// Delete
	@RequestMapping(value = "/fleet/vehicleMakes/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		vehicleMakeService.delete(id);

		return "redirect:/fleet/vehicleMakes";
	}



}
