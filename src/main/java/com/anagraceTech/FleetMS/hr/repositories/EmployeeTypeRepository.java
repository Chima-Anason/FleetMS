package com.anagraceTech.FleetMS.hr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.hr.models.EmployeeType;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {
	
	@Query(value = "select e from EmployeeType e where " +
		       "concat(e.description, e.details) like %?1%")
		List<EmployeeType> findByKeyword(String keyword);

}
