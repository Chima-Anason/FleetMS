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

import com.anagraceTech.FleetMS.fleet.models.VehicleModel;
import com.anagraceTech.FleetMS.fleet.services.VehicleModelService;

@Controller
public class VehicleModelController {

	@Autowired
	private VehicleModelService vehicleModelService;

	// Fetch all 
	@GetMapping("/fleet/vehicleModels")
	public String getAll(Model model, String keyword) {

		List<VehicleModel> vehicleModels;
		
		if(keyword==null) {
			vehicleModels = vehicleModelService.getAll();
		}else {
			vehicleModels = vehicleModelService.findByKeyword(keyword);
		}

		model.addAttribute("vehicleModels", vehicleModels);
		model.addAttribute("searchAction", "/fleet/vehicleModels");

		return "fleet/vehicleModels";
	}

	// Get By Id
	@GetMapping("/fleet/vehicleModel/{id}")
	@ResponseBody
	public VehicleModel getById(@PathVariable Integer id) {
		return vehicleModelService.getById(id);
	}


	// Save
	@PostMapping("/fleet/vehicleModels")
	public String save(VehicleModel vehicleModel) {

		System.out.println(vehicleModel);
		vehicleModelService.save(vehicleModel);
		return "redirect:/fleet/vehicleModels";
	}

	// Delete
	@RequestMapping(value = "/fleet/vehicleModels/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		vehicleModelService.delete(id);

		return "redirect:/fleet/vehicleModels";
	}



}
