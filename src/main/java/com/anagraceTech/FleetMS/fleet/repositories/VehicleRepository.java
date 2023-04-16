package com.anagraceTech.FleetMS.fleet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.fleet.models.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	@Query(value = "select v from Vehicle v where " +
		       "concat(v.name) like %?1%")
		List<Vehicle> findByKeyword(String keyword);

}
