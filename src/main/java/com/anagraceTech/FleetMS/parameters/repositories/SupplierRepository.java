package com.anagraceTech.FleetMS.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anagraceTech.FleetMS.parameters.models.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
