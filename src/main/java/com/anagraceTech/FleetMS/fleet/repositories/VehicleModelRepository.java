package com.anagraceTech.FleetMS.fleet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.fleet.models.VehicleModel;

@Repository
public interface VehicleModelRepository extends JpaRepository<VehicleModel, Integer> {
	
	@Query(value = "select v from VehicleModel v where " +
		       "concat(v.description, v.details) like %?1%")
		List<VehicleModel> findByKeyword(String keyword);

}
