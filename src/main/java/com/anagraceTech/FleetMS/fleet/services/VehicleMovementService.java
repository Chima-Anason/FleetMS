package com.anagraceTech.FleetMS.fleet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.fleet.models.VehicleMovement;
import com.anagraceTech.FleetMS.fleet.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	
	public List<VehicleMovement> getAll() {
		return vehicleMovementRepository.findAll();
	}
	
	
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	
	public void delete(Integer id) {
		vehicleMovementRepository.deleteById(id);
	}


	public VehicleMovement getById(Integer id) {
        return vehicleMovementRepository.findById(id).orElse(null);
    }
	
	public List<VehicleMovement> findByKeyword(String keyword) {
		return vehicleMovementRepository.findByKeyword(keyword);
	}

}
