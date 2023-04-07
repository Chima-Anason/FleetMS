package com.anagraceTech.FleetMS.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.parameters.models.Client;
import com.anagraceTech.FleetMS.parameters.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	public List<Client> getAll() {
		return clientRepository.findAll();
	}
	
	
	public void save(Client client) {
		clientRepository.save(client);
	}
	
	
	public void delete(Integer id) {
		clientRepository.deleteById(id);
	}


	public Client getById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }
	
	
	public List<Client> findByKeyword(String keyword) {
		return clientRepository.findByKeyword(keyword);
	}

}
