package com.anagraceTech.FleetMS.parameters.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.parameters.models.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
	
	@Query(value = "select s from Supplier s where " +
		       "concat(s.name, s.city, s.address) like %?1%")
		List<Supplier> findByKeyword(String keyword);

}
