package com.anagraceTech.FleetMS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

	
	
	@RequestMapping("/layout")
	public String getIndexPage() {

		return "_layout";
	}

	@RequestMapping("/index")
	public String getlayout() {

		return "index2";
	}
}
