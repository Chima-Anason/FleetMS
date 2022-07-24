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

import com.anagraceTech.FleetMS.fleet.models.Vehicle;
import com.anagraceTech.FleetMS.fleet.services.VehicleMakeService;
import com.anagraceTech.FleetMS.fleet.services.VehicleModelService;
import com.anagraceTech.FleetMS.fleet.services.VehicleService;
import com.anagraceTech.FleetMS.fleet.services.VehicleStatusService;
import com.anagraceTech.FleetMS.fleet.services.VehicleTypeService;
import com.anagraceTech.FleetMS.parameters.services.LocationService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	@Autowired private VehicleTypeService vehicleTypeService;
	@Autowired private VehicleMakeService vehicleMakeService;
	@Autowired private VehicleModelService vehicleModelService;
	@Autowired private LocationService locationService;
	//@Autowired private EmployeeService employeeService ;
	@Autowired private VehicleStatusService vehicleStatusService;
	
	
	
	
	public Model addModelAttributes(Model model){
		model.addAttribute("vehicles", vehicleService.getAll());
		model.addAttribute("vehicleTypes", vehicleTypeService.getAll());
		model.addAttribute("vehicleModels", vehicleModelService.getAll());
		model.addAttribute("vehicleMakes", vehicleMakeService.getAll());
		model.addAttribute("locations", locationService.getAll());
		//model.addAttribute("employees", employeeService.getAll());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getAll());
		return model;
	}
	
	
	//Fetch all
	@GetMapping("/fleet/vehicles")
	public String getAll(Model model, String keyword) {
		
		List<Vehicle> vehicles = vehicleService.getAll();
		
		if(keyword==null) {
			addModelAttributes(model);
		}else {
			vehicles = vehicleService.findByKeyword(keyword);
		}
		
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("searchAction", "/fleet/states");
		
		return "fleet/vehicles";
	}
	
	
	//Go to Add page
	@GetMapping("/fleet/vehicleAdd")
	public String addPage(Model model) {
		addModelAttributes(model);
		
		return "fleet/vehicleAdd";
	}
	
	//Save
	@PostMapping("/fleet/vehicles")
	public String save(Vehicle vehicle) {
		
		System.out.println(vehicle);
		vehicleService.save(vehicle);
		return "redirect:/fleet/vehicles";
	}
	
	
	
	//Delete
	@RequestMapping(value = "/fleet/vehicle/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		vehicleService.delete(id);
		
		return "redirect:/fleet/vehicles";
	}
	
	//Go to Edit/Detail page
	@GetMapping("/fleet/vehicle/{op}/{id}")
	public String editAndDetails(@PathVariable Integer id, @PathVariable String op, Model model) {
		addModelAttributes(model);
		Vehicle vehicle = vehicleService.getById(id);
		
		model.addAttribute("vehicle", vehicle);
		
		return "fleet/vehicle" + op;
	}
	
		
		
		
		
	
	
}
