package com.anagraceTech.FleetMS.fleet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.fleet.models.VehicleModel;
import com.anagraceTech.FleetMS.fleet.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	
	public List<VehicleModel> getAll() {
		return vehicleModelRepository.findAll();
	}
	
	
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}
	
	
	public void delete(Integer id) {
		vehicleModelRepository.deleteById(id);
	}


	public VehicleModel getById(Integer id) {
        return vehicleModelRepository.findById(id).orElse(null);
    }
	
	public List<VehicleModel> findByKeyword(String keyword) {
		return vehicleModelRepository.findByKeyword(keyword);
	}

}
