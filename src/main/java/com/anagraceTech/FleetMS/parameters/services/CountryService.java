package com.anagraceTech.FleetMS.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	public List<Country> findByKeyword(String keyword) {
		return countryRepository.findByKeyword(keyword);
	}
	
	public List<Country> findAllWithSort(String field, String direction) {
		//Asc or Desc
		Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(field).ascending() : Sort.by(field).descending();
		
		return countryRepository.findAll(sort);
	}

}
