package com.anagraceTech.FleetMS.fleet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.fleet.models.VehicleHire;

@Repository
public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {
	
	@Query(value = "select v from VehicleHire v where " +
		       "concat(v.vehicle, v.dateIn, v.dateOut, v.timeOut) like %?1%")
		List<VehicleHire> findByKeyword(String keyword);

}
