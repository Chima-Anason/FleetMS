package com.anagraceTech.FleetMS.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.hr.models.EmployeeType;
import com.anagraceTech.FleetMS.hr.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	
	public List<EmployeeType> getAll() {
		return employeeTypeRepository.findAll();
	}
	
	
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}
	
	
	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);
	}


	public EmployeeType getById(Integer id) {
        return employeeTypeRepository.findById(id).orElse(null);
    }
	
	public List<EmployeeType> findByKeyword(String keyword) {
		return employeeTypeRepository.findByKeyword(keyword);
	}

}
