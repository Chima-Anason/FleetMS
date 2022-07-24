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

import com.anagraceTech.FleetMS.fleet.models.VehicleMaintenance;
import com.anagraceTech.FleetMS.fleet.services.VehicleMaintenanceService;
import com.anagraceTech.FleetMS.fleet.services.VehicleService;
import com.anagraceTech.FleetMS.parameters.services.SupplierService;

@Controller
public class VehicleMaintenanceController {

	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired private SupplierService supplierService;
	@Autowired private VehicleService vehicleService;
	
	
	
	
	
	public Model addModelAttributes(Model model){
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getAll());
		model.addAttribute("suppliers", supplierService.getAll());
		model.addAttribute("vehicles", vehicleService.getAll());
		
		return model;
	}
	
	
	//Fetch all
	@GetMapping("/fleet/vehicleMaintenances")
	public String getAll(Model model, String keyword) {
		
		List<VehicleMaintenance> vehicleMaintenances = vehicleMaintenanceService.getAll();
		
		if(keyword==null) {
			addModelAttributes(model);
		}else {
			vehicleMaintenances = vehicleMaintenanceService.findByKeyword(keyword);
		}
		
		model.addAttribute("vehicleMaintenances", vehicleMaintenances);
		model.addAttribute("searchAction", "/fleet/vehicleMaintenances");
		
		return "fleet/vehicleMaintenances";
	}
	
	
	//Go to Add page
	@GetMapping("/fleet/vehicleMaintenanceAdd")
	public String addPage(Model model) {
		addModelAttributes(model);
		
		return "fleet/vehicleMaintenanceAdd";
	}
	
	//Save
	@PostMapping("/fleet/vehicleMaintenances")
	public String save(VehicleMaintenance vehicleMaintenance) {
		
		System.out.println(vehicleMaintenance);
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/fleet/vehicleMaintenances";
	}
	
	
	
	//Delete
	@RequestMapping(value = "/fleet/vehicleMaintenance/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		vehicleMaintenanceService.delete(id);
		
		return "redirect:/fleet/vehicleMaintenances";
	}
	
	//Go to Edit/Detail page
	@GetMapping("/fleet/vehicleMaintenance/{op}/{id}")
	public String editAndDetails(@PathVariable Integer id, @PathVariable String op, Model model) {
		addModelAttributes(model);
		VehicleMaintenance vehicleMaintenance = vehicleMaintenanceService.getById(id);
		
		model.addAttribute("vehicleMaintenance", vehicleMaintenance);
		
		return "fleet/vehicleMaintenance" + op;
	}
	
		
		
		
		
	
	
}
