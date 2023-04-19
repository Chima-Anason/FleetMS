package com.anagraceTech.FleetMS.hr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.hr.models.EmployeeStatus;

@Repository
public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatus, Integer> {
	
	@Query(value = "select e from EmployeeStatus e where " +
		       "concat(e.description, e.details) like %?1%")
		List<EmployeeStatus> findByKeyword(String keyword);

}
