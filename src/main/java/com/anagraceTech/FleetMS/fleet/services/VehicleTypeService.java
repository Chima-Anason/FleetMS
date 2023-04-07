package com.anagraceTech.FleetMS.fleet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.fleet.models.VehicleType;
import com.anagraceTech.FleetMS.fleet.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	
	public List<VehicleType> getAll() {
		return vehicleTypeRepository.findAll();
	}
	
	
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}
	
	
	public void delete(Integer id) {
		vehicleTypeRepository.deleteById(id);
	}


	public VehicleType getById(Integer id) {
        return vehicleTypeRepository.findById(id).orElse(null);
    }
	
	public List<VehicleType> findByKeyword(String keyword) {
		return vehicleTypeRepository.findByKeyword(keyword);
	}

}
