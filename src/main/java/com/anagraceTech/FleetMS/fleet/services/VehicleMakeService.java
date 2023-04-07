package com.anagraceTech.FleetMS.fleet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.fleet.models.VehicleMake;
import com.anagraceTech.FleetMS.fleet.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	
	public List<VehicleMake> getAll() {
		return vehicleMakeRepository.findAll();
	}
	
	
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
	
	
	public void delete(Integer id) {
		vehicleMakeRepository.deleteById(id);
	}


	public VehicleMake getById(Integer id) {
        return vehicleMakeRepository.findById(id).orElse(null);
    }
	
	public List<VehicleMake> findByKeyword(String keyword) {
		return vehicleMakeRepository.findByKeyword(keyword);
	}

}
