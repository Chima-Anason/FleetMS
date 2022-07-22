package com.anagraceTech.FleetMS.parameters.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.parameters.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	@Query(value = "select c from Client c where " +
		       "concat(c.name, c.address, c.city) like %?1%")
		List<Client> findByKeyword(String keyword);

}
