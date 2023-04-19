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

import com.anagraceTech.FleetMS.hr.models.JobTitle;
import com.anagraceTech.FleetMS.hr.services.JobTitleService;

@Controller
public class JobTitleController {

	@Autowired
	private JobTitleService jobTitleService;

	// Fetch all 
	@GetMapping("/hr/jobTitles")
	public String getAll(Model model, String keyword) {

		List<JobTitle> jobTitles;
		
		if(keyword==null) {
			jobTitles = jobTitleService.getAll();
		}else {
			jobTitles = jobTitleService.findByKeyword(keyword);
		}

		model.addAttribute("jobTitles", jobTitles);
		model.addAttribute("searchAction", "/hr/jobTitles");

		return "hr/jobTitles";
	}

	// Get By Id
	@GetMapping("/hr/jobTitle/{id}")
	@ResponseBody
	public JobTitle getById(@PathVariable Integer id) {
		return jobTitleService.getById(id);
	}


	// Save
	@PostMapping("/hr/jobTitles")
	public String save(JobTitle jobTitle) {

		System.out.println(jobTitle);
		jobTitleService.save(jobTitle);
		return "redirect:/hr/jobTitles";
	}

	// Delete
	@RequestMapping(value = "/hr/jobTitles/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		jobTitleService.delete(id);

		return "redirect:/hr/jobTitles";
	}



}
