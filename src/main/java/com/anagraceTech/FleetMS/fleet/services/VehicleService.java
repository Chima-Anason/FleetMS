package com.anagraceTech.FleetMS.fleet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.fleet.models.Vehicle;
import com.anagraceTech.FleetMS.fleet.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	public List<Vehicle> getAll() {
		return vehicleRepository.findAll();
	}
	
	
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	
	public void delete(Integer id) {
		vehicleRepository.deleteById(id);
	}


	public Vehicle getById(Integer id) {
        return vehicleRepository.findById(id).orElse(null);
    }
	
	public List<Vehicle> findByKeyword(String keyword) {
		return vehicleRepository.findByKeyword(keyword);
	}

}
