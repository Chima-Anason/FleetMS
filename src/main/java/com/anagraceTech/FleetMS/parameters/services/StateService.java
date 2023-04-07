package com.anagraceTech.FleetMS.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.parameters.models.State;
import com.anagraceTech.FleetMS.parameters.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	
	public List<State> getAll() {
		return stateRepository.findAll();
	}
	
	
	public void save(State state) {
		stateRepository.save(state);
	}
	
	
	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}


	public State getById(Integer id) {
        return stateRepository.findById(id).orElse(null);
    }
	
	
	public List<State> findByKeyword(String keyword) {
		return stateRepository.findByKeyword(keyword);
	}

}
