package com.anagraceTech.FleetMS.parameters.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.parameters.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	
	@Query(value = "select s from State s where " +
		       "concat(s.name, s.capital, s.code, s.details) like %?1%")
		List<State> findByKeyword(String keyword);

}
