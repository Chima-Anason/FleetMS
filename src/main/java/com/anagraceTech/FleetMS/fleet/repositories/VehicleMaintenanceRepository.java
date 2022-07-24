package com.anagraceTech.FleetMS.fleet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.fleet.models.VehicleMaintenance;

@Repository
public interface VehicleMaintenanceRepository extends JpaRepository<VehicleMaintenance, Integer> {
	
	@Query(value = "select v from VehicleMaintenance v where " +
		       "concat(v.vehicle, v.startDate, v.remarks) like %?1%")
		List<VehicleMaintenance> findByKeyword(String keyword);

}
