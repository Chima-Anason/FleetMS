package com.anagraceTech.FleetMS.fleet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.fleet.models.VehicleMake;

@Repository
public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Integer> {
	
	@Query(value = "select v from VehicleMake v where " +
		       "concat(v.description, v.details) like %?1%")
		List<VehicleMake> findByKeyword(String keyword);

}
