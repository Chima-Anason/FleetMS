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

import com.anagraceTech.FleetMS.fleet.models.VehicleStatus;
import com.anagraceTech.FleetMS.fleet.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService vehicleStatusService;

	// Fetch all 
	@GetMapping("/fleet/vehicleStatuses")
	public String getAll(Model model, String keyword) {

		List<VehicleStatus> vehicleStatuses;
		
		if(keyword==null) {
			vehicleStatuses = vehicleStatusService.getAll();
		}else {
			vehicleStatuses = vehicleStatusService.findByKeyword(keyword);
		}

		model.addAttribute("vehicleStatuses", vehicleStatuses);
		model.addAttribute("searchAction", "/fleet/vehicleStatuses");

		return "fleet/vehicleStatuses";
	}

	// Get By Id
	@GetMapping("/fleet/vehicleStatus/{id}")
	@ResponseBody
	public VehicleStatus getById(@PathVariable Integer id) {
		return vehicleStatusService.getById(id);
	}


	// Save
	@PostMapping("/fleet/vehicleStatuses")
	public String save(VehicleStatus vehicleStatus) {

		System.out.println(vehicleStatus);
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/fleet/vehicleStatuses";
	}

	// Delete
	@RequestMapping(value = "/fleet/vehicleStatuses/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		vehicleStatusService.delete(id);

		return "redirect:/fleet/vehicleStatuses";
	}



}
