package com.anagraceTech.FleetMS.parameters.controllers;

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

import com.anagraceTech.FleetMS.parameters.models.Contact;
import com.anagraceTech.FleetMS.parameters.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	// Fetch all 
	@GetMapping("/parameters/contacts")
	public String getAll(Model model) {

		List<Contact> contacts = contactService.getAll();

		model.addAttribute("contacts", contacts);

		return "parameters/contacts";
	}

	// Get By Id
	@GetMapping("/parameters/contact/{id}")
	@ResponseBody
	public Contact getById(@PathVariable Integer id) {
		return contactService.getById(id);
	}

	// Go to Add page
	@GetMapping("/parameters/contactAdd")
	public String addPage() {

		return "parameters/contactAdd";
	}

	// Save
	@PostMapping("/parameters/contacts")
	public String save(Contact contact) {

		System.out.println(contact);
		contactService.save(contact);
		return "redirect:/parameters/contacts";
	}

	// Delete
	@RequestMapping(value = "/parameters/contacts/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		contactService.delete(id);

		return "redirect:/parameters/contacts";
	}

	// Go to Edit/Details page
	@GetMapping("/parameters/contact/{op}/{id}")
	public String editAndDetails(@PathVariable Integer id,@PathVariable String op, Model model) {
		Contact contact = contactService.getById(id);

		model.addAttribute("contact", contact);

		return "parameters/contact" + op;
	}


}
