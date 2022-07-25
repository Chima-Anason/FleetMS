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

import com.anagraceTech.FleetMS.hr.models.EmployeeType;
import com.anagraceTech.FleetMS.hr.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService employeeTypeService;

	// Fetch all 
	@GetMapping("/hr/employeeTypes")
	public String getAll(Model model, String keyword) {

		List<EmployeeType> employeeTypes;
		
		if(keyword==null) {
			employeeTypes = employeeTypeService.getAll();
		}else {
			employeeTypes = employeeTypeService.findByKeyword(keyword);
		}

		model.addAttribute("employeeTypes", employeeTypes);
		model.addAttribute("searchAction", "/hr/employeeTypes");

		return "hr/employeeTypes";
	}

	// Get By Id
	@GetMapping("/hr/employeeType/{id}")
	@ResponseBody
	public EmployeeType getById(@PathVariable Integer id) {
		return employeeTypeService.getById(id);
	}


	// Save
	@PostMapping("/hr/employeeTypes")
	public String save(EmployeeType employeeType) {

		System.out.println(employeeType);
		employeeTypeService.save(employeeType);
		return "redirect:/hr/employeeTypes";
	}

	// Delete
	@RequestMapping(value = "/hr/employeeTypes/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		employeeTypeService.delete(id);

		return "redirect:/hr/employeeTypes";
	}



}
