package com.anagraceTech.FleetMS.parameters.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anagraceTech.FleetMS.parameters.models.Country;
import com.anagraceTech.FleetMS.parameters.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	// Fetch all countries
//	@GetMapping("/parameters/countries")
//	public String getAll(Model model, String keyword) {
//
//		List<Country> countries;
//		
//		if(keyword==null) {
//			countries = countryService.getAll();
//		}else {
//			countries = countryService.findByKeyword(keyword);
//			if(countries.isEmpty()) {
//				countries = null;
//				System.out.println(countries);
//			}
//		}
//
//		model.addAttribute("countries", countries);
//		model.addAttribute("searchAction", "/parameters/countries");
//
//		return "parameters/countries";
//	}
	
	
	// Fetch all countries by search
	@GetMapping("/parameters/countries/{pageNumber}")
	public String getAll(Model model, String keyword, @PathVariable("pageNumber") int currentPage) {

		Page<Country> page;
		
		if(keyword==null) {
			page = countryService.findPage(currentPage);
		}else {
			page = countryService.findByKeyword(keyword, currentPage);
		}
		
		int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<Country> countries = page.getContent();
        
        if(page.isEmpty()) {
			countries = null;
			System.out.println(countries);
		}

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
		model.addAttribute("countries", countries);
		model.addAttribute("searchAction", "/parameters/countries/"+currentPage);

		return "parameters/countries";
	}
	
	
	
	// Fetch all countries
	@GetMapping("/parameters/countries")
    public String getAllPages(Model model){
        return getOnePage(model, 1);
    }
	
	
	
	// Fetch all countries by page
	@GetMapping("/parameters/countries/page/{pageNumber}")
    public String  getOnePage(Model model, @PathVariable("pageNumber") int currentPage){
        Page<Country> page = countryService.findPage(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<Country> countries = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("countries", countries);
        
      //for Search
        model.addAttribute("searchAction", "/parameters/countries/"+currentPage);

        return "/parameters/countries";
    }
	
	// Fetch all countries with Sort
    @GetMapping("/parameters/countries/page/{pageNumber}/{field}")
    public String getPageWithSort(Model model,
                                  @PathVariable("pageNumber") int currentPage,
                                  @PathVariable String field,
                                  @PathParam("sortDir") String sortDir) {

        Page<Country> page = countryService.findPageWithSort(field, sortDir, currentPage);
        List<Country> countries = page.getContent();
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);

        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("countries", countries);
        
        
        model.addAttribute("searchAction", "/parameters/countries/"+currentPage);
        
        return "/parameters/countries";
    }

	// Get Country By Id
	@GetMapping("/parameters/country/{id}")
	@ResponseBody
	public Country getById(@PathVariable Integer id) {
		return countryService.getById(id);
	}

	// Go to Add page
	@GetMapping("/parameters/countryAdd")
	public String addPage() {

		return "parameters/countryAdd";
	}

	// Save
	@PostMapping("/parameters/countries")
    public String save(Country country){
        countryService.save(country);
        return "redirect:/parameters/countries";
    }

	// Delete
	@RequestMapping(value = "/parameters/countries/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public  String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/parameters/countries";
    }

	// Go to Edit and Details page
	@GetMapping("/parameters/country/{op}/{id}")
	public String editAndDetails(@PathVariable Integer id,@PathVariable String op, Model model) {
		Country country = countryService.getById(id);

		model.addAttribute("country", country);

		return "parameters/country" + op;
	}


}
