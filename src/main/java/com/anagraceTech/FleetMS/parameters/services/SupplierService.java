package com.anagraceTech.FleetMS.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.parameters.models.Supplier;
import com.anagraceTech.FleetMS.parameters.repositories.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	
	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}
	
	
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	
	public void delete(Integer id) {
		supplierRepository.deleteById(id);
	}


	public Supplier getById(Integer id) {
        return supplierRepository.findById(id).orElse(null);
    }

}
