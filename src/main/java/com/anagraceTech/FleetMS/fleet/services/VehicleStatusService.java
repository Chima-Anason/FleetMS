package com.anagraceTech.FleetMS.fleet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.fleet.models.VehicleStatus;
import com.anagraceTech.FleetMS.fleet.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {
	
	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	
	public List<VehicleStatus> getAll() {
		return vehicleStatusRepository.findAll();
	}
	
	
	public void save(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}
	
	
	public void delete(Integer id) {
		vehicleStatusRepository.deleteById(id);
	}


	public VehicleStatus getById(Integer id) {
        return vehicleStatusRepository.findById(id).orElse(null);
    }
	
	public List<VehicleStatus> findByKeyword(String keyword) {
		return vehicleStatusRepository.findByKeyword(keyword);
	}

}
