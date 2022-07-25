package com.anagraceTech.FleetMS.hr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.hr.models.JobTitle;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
	
	@Query(value = "select j from JobTitle j where " +
		       "concat(j.description, j.details) like %?1%")
		List<JobTitle> findByKeyword(String keyword);

}
