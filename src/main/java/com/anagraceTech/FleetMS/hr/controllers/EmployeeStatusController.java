package com.anagraceTech.FleetMS.hr.controllers;

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

import com.anagraceTech.FleetMS.hr.models.EmployeeStatus;
import com.anagraceTech.FleetMS.hr.services.EmployeeStatusService;

@Controller
public class EmployeeStatusController {

	@Autowired
	private EmployeeStatusService employeeStatusService;

	// Fetch all 
	@GetMapping("/hr/employeeStatuses")
	public String getAll(Model model, String keyword) {

		List<EmployeeStatus> employeeStatuses;
		
		if(keyword==null) {
			employeeStatuses = employeeStatusService.getAll();
		}else {
			employeeStatuses = employeeStatusService.findByKeyword(keyword);
		}

		model.addAttribute("employeeStatuses", employeeStatuses);
		model.addAttribute("searchAction", "/hr/employeeStatuses");

		return "hr/employeeStatuses";
	}

	// Get By Id
	@GetMapping("/hr/employeeStatus/{id}")
	@ResponseBody
	public EmployeeStatus getById(@PathVariable Integer id) {
		return employeeStatusService.getById(id);
	}


	// Save
	@PostMapping("/hr/employeeStatuses")
	public String save(EmployeeStatus employeeStatus) {

		System.out.println(employeeStatus);
		employeeStatusService.save(employeeStatus);
		return "redirect:/hr/employeeStatuses";
	}

	// Delete
	@RequestMapping(value = "/hr/employeeStatuses/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		employeeStatusService.delete(id);

		return "redirect:/hr/employeeStatuses";
	}



}
