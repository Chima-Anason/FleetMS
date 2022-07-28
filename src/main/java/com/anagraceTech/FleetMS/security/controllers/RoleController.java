package com.anagraceTech.FleetMS.security.controllers;

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

import com.anagraceTech.FleetMS.security.models.Role;
import com.anagraceTech.FleetMS.security.services.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	// Fetch all 
	@GetMapping("/security/roles")
	public String getAll(Model model, String keyword) {

		List<Role> roles;
		
		if(keyword==null) {
			roles = roleService.getAll();
		}else {
			roles = roleService.findByKeyword(keyword);
		}

		model.addAttribute("roles", roles);
		model.addAttribute("searchAction", "/security/roles");

		return "security/roles";
	}

	// Get By Id
	@GetMapping("/security/role/{id}")
	@ResponseBody
	public Role getById(@PathVariable Integer id) {
		return roleService.getById(id);
	}


	// Save
	@PostMapping("/security/roles")
	public String save(Role role) {

		System.out.println(role);
		roleService.save(role);
		return "redirect:/security/roles";
	}

	// Delete
	@RequestMapping(value = "/security/roles/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		roleService.delete(id);

		return "redirect:/security/roles";
	}
	
	
	//assign role to user
	@RequestMapping("/security/role/assign/{userId}/{roleId}")
	public String assignRole(@PathVariable Integer userId, @PathVariable Integer roleId) {
		roleService.assignUserRole(userId, roleId);
		return "redirect:/security/user/Edit/"+userId;
	}
	
	
	//Unassign role from user
	@RequestMapping("/security/role/unassign/{userId}/{roleId}")
		public String unassignRole(@PathVariable Integer userId, @PathVariable Integer roleId) {
			roleService.unassignUserRole(userId, roleId);
			return "redirect:/security/user/Edit/"+userId;
		}

}
