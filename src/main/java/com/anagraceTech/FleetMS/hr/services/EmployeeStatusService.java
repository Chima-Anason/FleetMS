package com.anagraceTech.FleetMS.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.hr.models.EmployeeStatus;
import com.anagraceTech.FleetMS.hr.repositories.EmployeeStatusRepository;

@Service
public class EmployeeStatusService {
	
	@Autowired
	private EmployeeStatusRepository employeeStatusRepository;
	
	
	public List<EmployeeStatus> getAll() {
		return employeeStatusRepository.findAll();
	}
	
	
	public void save(EmployeeStatus employeeStatus) {
		employeeStatusRepository.save(employeeStatus);
	}
	
	
	public void delete(Integer id) {
		employeeStatusRepository.deleteById(id);
	}


	public EmployeeStatus getById(Integer id) {
        return employeeStatusRepository.findById(id).orElse(null);
    }
	
	public List<EmployeeStatus> findByKeyword(String keyword) {
		return employeeStatusRepository.findByKeyword(keyword);
	}

}
