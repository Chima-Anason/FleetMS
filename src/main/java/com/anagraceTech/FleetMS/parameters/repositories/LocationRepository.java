package com.anagraceTech.FleetMS.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.parameters.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
