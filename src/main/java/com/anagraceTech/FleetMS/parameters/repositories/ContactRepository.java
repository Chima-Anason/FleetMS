package com.anagraceTech.FleetMS.parameters.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.parameters.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	@Query(value = "select c from Contact c where " +
		       "concat(c.firstname, c.lastname) like %?1%")
		List<Contact> findByKeyword(String keyword);

}
