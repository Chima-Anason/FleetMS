package com.anagraceTech.FleetMS.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.security.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	@Query(value = "select r from Role r where " +
		       "concat(r.description, r.details) like %?1%")
		List<Role> findByKeyword(String keyword);
	
	
	@Query(
            value = "SELECT * FROM role WHERE id NOT IN (SELECT role_id FROM user_role WHERE user_id = ?1)",
            nativeQuery = true
    )
    List<Role> getUserNotRoles(Integer userId);

}
