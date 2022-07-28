package com.anagraceTech.FleetMS.security.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.security.models.Role;
import com.anagraceTech.FleetMS.security.models.User;
import com.anagraceTech.FleetMS.security.repositories.RoleRepository;
import com.anagraceTech.FleetMS.security.repositories.UserRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired private UserRepository userRepository;
	
	
	public List<Role> getAll() {
		return roleRepository.findAll();
	}
	
	
	public void save(Role role) {
		roleRepository.save(role);
	}
	
	
	public void delete(Integer id) {
		roleRepository.deleteById(id);
	}


	public Role getById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }
	
	public List<Role> findByKeyword(String keyword) {
		return roleRepository.findByKeyword(keyword);
	}
	
	
	//Assign Role to User
	public void assignUserRole(Integer userId, Integer roleId) {
		
		User user = userRepository.findById(userId).orElse(null);
		Role role = roleRepository.findById(roleId).orElse(null);
		
		Set<Role> userRoles = user.getRoles();
		userRoles.add(role);
		user.setRoles(userRoles);
		userRepository.save(user);
		
	}
	
	//Unassign Role to User
	public void unassignUserRole(Integer userId, Integer roleId) {
		
		User user = userRepository.findById(userId).orElse(null);
		user.getRoles().removeIf(x -> x.getId()==roleId);
		userRepository.save(user);
		
	}
	
	//Get list of Roles assigned to user
	public Set<Role> getUserRoles(User user) {
		return user.getRoles();
	}
	
	
	//Get list of Roles Not assigned to User
	public List<Role> getUserNotRoles(User user) {
		return roleRepository.getUserNotRoles(user.getId());
	}

}
