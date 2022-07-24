package com.anagraceTech.FleetMS.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Country> findPage(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber-1, 8);
		
		return countryRepository.findAll(pageable);
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
	
	public Page<Country> findByKeyword(String keyword,int pageNumber) {
		
		Pageable pageable = PageRequest.of(pageNumber -1, 8);

		return countryRepository.findByKeyword(keyword, pageable);
	}

	
	public Page<Country> findPageWithSort(String field, String direction, int pageNumber) {
		//Asc or Desc
		Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(field).ascending() : Sort.by(field).descending();
		
		
		Pageable pageable = PageRequest.of(pageNumber -1, 8, sort);
		
		return countryRepository.findAll(pageable);
	}

}
