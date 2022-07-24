package com.anagraceTech.FleetMS.fleet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.fleet.models.VehicleHire;
import com.anagraceTech.FleetMS.fleet.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {
	
	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	
	public List<VehicleHire> getAll() {
		return vehicleHireRepository.findAll();
	}
	
	
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}
	
	
	public void delete(Integer id) {
		vehicleHireRepository.deleteById(id);
	}


	public VehicleHire getById(Integer id) {
        return vehicleHireRepository.findById(id).orElse(null);
    }
	
	public List<VehicleHire> findByKeyword(String keyword) {
		return vehicleHireRepository.findByKeyword(keyword);
	}

}
