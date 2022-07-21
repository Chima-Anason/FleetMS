package com.anagraceTech.FleetMS;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.anagraceTech.FleetMS.parameters.models.Country;
import com.anagraceTech.FleetMS.parameters.repositories.CountryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CountryTest {
	
	@Autowired
	private CountryRepository countryRepository;
	
	//FindById
	@Test
	public void testFindById() {
		 Country country = countryRepository.findById(4).orElse(null);
		 assertNotNull(country);
	}

	
	@Test
	public void testFindByIdError() {
		 Country country = countryRepository.findById(100).orElse(null);
		 assertNotNull(country);
	}
	
	@Test
	public void testFindByIdNull() {
		 Country country = countryRepository.findById(100).orElse(null);
		 assertNull(country);
	}
	
	
	//FindByIdEmpty

}
