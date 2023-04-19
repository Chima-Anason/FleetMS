package com.anagraceTech.FleetMS.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anagraceTech.FleetMS.hr.models.JobTitle;
import com.anagraceTech.FleetMS.hr.repositories.JobTitleRepository;

@Service
public class JobTitleService {
	
	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	
	public List<JobTitle> getAll() {
		return jobTitleRepository.findAll();
	}
	
	
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}
	
	
	public void delete(Integer id) {
		jobTitleRepository.deleteById(id);
	}


	public JobTitle getById(Integer id) {
        return jobTitleRepository.findById(id).orElse(null);
    }
	
	public List<JobTitle> findByKeyword(String keyword) {
		return jobTitleRepository.findByKeyword(keyword);
	}

}
