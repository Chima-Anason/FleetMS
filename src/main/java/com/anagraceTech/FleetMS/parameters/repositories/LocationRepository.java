package com.anagraceTech.FleetMS.parameters.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.parameters.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	@Query(value = "select l from Location l where " +
		       "concat(l.city, l.address) like %?1%")
		List<Location> findByKeyword(String keyword);

}
