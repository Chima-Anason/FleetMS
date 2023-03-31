package com.anagraceTech.FleetMS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

	
	
	@RequestMapping("/index")
	public String getIndexPage() {

		return "index";
	}

	@RequestMapping("/hr")
	public String hr() {

		return "/hr/index";
	}
	
	@RequestMapping("/fleet")
	public String fleet() {

		return "/fleet/index";
	}
	
	
	@RequestMapping("/accounts")
	public String accounts() {

		return "/accounts/index";
	}
	
	
	@RequestMapping("/helpdesk")
	public String helpdesk() {

		return "/helpdesk/index";
	}
	
	
	@RequestMapping("/parameters")
	public String parameters() {

		return "/parameters/index";
	}
	
	
	@RequestMapping("/payroll")
	public String payroll() {

		return "/payroll/index";
	}
	
	
	@RequestMapping("/reports")
	public String reports() {

		return "/reports/index";
	}
	
	
	@RequestMapping("/security")
	public String security() {

		return "/security/index";
	}
}
