package com.anagraceTech.FleetMS.fleet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.fleet.models.VehicleMovement;

@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {
	
	@Query(value = "select v from VehicleMovement v where " +
		       "concat(v.vehicle, v.location1, v.date1, v.location2, v.date2) like %?1%")
		List<VehicleMovement> findByKeyword(String keyword);

}
