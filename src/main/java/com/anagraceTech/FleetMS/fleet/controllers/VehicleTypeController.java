package com.anagraceTech.FleetMS.fleet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anagraceTech.FleetMS.fleet.models.VehicleType;
import com.anagraceTech.FleetMS.fleet.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;

	// Fetch all 
	@GetMapping("/fleet/vehicleTypes")
	public String getAll(Model model) {

		model.addAttribute("vehicleTypes", vehicleTypeService.getAll());

		return "fleet/vehicleTypes";
	}

	// Get By Id
	@GetMapping("/fleet/vehicleType/{id}")
	@ResponseBody
	public VehicleType getById(@PathVariable Integer id) {
		return vehicleTypeService.getById(id);
	}


	// Save
	@PostMapping("/fleet/vehicleTypes")
	public String save(VehicleType vehicleType) {

		System.out.println(vehicleType);
		vehicleTypeService.save(vehicleType);
		return "redirect:/fleet/vehicleTypes";
	}

	// Delete
	@RequestMapping(value = "/fleet/vehicleTypes/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		vehicleTypeService.delete(id);

		return "redirect:/fleet/vehicleTypes";
	}



}
