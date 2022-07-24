package com.anagraceTech.FleetMS.fleet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.fleet.models.VehicleMaintenance;
import com.anagraceTech.FleetMS.fleet.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {
	
	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	
	public List<VehicleMaintenance> getAll() {
		return vehicleMaintenanceRepository.findAll();
	}
	
	
	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
	
	public void delete(Integer id) {
		vehicleMaintenanceRepository.deleteById(id);
	}


	public VehicleMaintenance getById(Integer id) {
        return vehicleMaintenanceRepository.findById(id).orElse(null);
    }
	
	public List<VehicleMaintenance> findByKeyword(String keyword) {
		return vehicleMaintenanceRepository.findByKeyword(keyword);
	}

}
