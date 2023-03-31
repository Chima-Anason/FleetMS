package com.anagraceTech.FleetMS.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.parameters.models.Country;
import com.anagraceTech.FleetMS.parameters.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	
	public List<Country> getAll() {
		return countryRepository.findAll();
	}
	
	
	public void save(Country country) {
		countryRepository.save(country);
	}
	
	
	public void delete(Integer id) {
		countryRepository.deleteById(id);
	}


	public Country getById(Integer id) {
        return countryRepository.findById(id).orElse(null);
    }

}
