package com.anagraceTech.FleetMS.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.parameters.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
