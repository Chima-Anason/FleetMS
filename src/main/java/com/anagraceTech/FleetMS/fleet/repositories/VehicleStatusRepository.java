package com.anagraceTech.FleetMS.fleet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.fleet.models.VehicleStatus;

@Repository
public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Integer> {
	
	@Query(value = "select v from VehicleStatus v where " +
		       "concat(v.description, v.details) like %?1%")
		List<VehicleStatus> findByKeyword(String keyword);

}
