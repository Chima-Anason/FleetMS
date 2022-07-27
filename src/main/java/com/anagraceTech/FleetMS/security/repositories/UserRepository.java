package com.anagraceTech.FleetMS.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anagraceTech.FleetMS.security.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);

}
