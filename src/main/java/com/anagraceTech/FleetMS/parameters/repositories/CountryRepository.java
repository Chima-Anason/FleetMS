package com.anagraceTech.FleetMS.parameters.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.parameters.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
	@Query(value = "select c from Country c where " +
	       "concat(c.description, c.capital, c.code, c.continent, c.nationality) like %?1%")
	Page<Country> findByKeyword(String keyword, Pageable pageable);
	

}
