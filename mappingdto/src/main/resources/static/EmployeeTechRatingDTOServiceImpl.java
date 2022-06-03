package com.dtoexample.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtoexample.demo.dto.EmployeeTechRatingDTO;
import com.dtoexample.demo.model.Employee;
import com.dtoexample.demo.model.TechRating;
import com.dtoexample.demo.repository.EmployeeTechRatingDTORepository;
import com.dtoexample.demo.service.EmployeeTechRatingDTOService;

@Service
public class EmployeeTechRatingDTOServiceImpl implements EmployeeTechRatingDTOService{
	
	@Autowired
	private EmployeeTechRatingDTORepository empTechRatingRepo;

	@Override
	public EmployeeTechRatingDTO saverating(EmployeeTechRatingDTO empTechRatingDto) {
		EmployeeTechRatingDTO savedResults = new EmployeeTechRatingDTO();
		try {
			if(empTechRatingDto != null) {
				List<Employee> getDetails = new ArrayList<Employee>();
				for(Employee results : getDetails) {
					results.setEmpName(empTechRatingDto.getEmpName());
					results.setEmpId(empTechRatingDto.getEmpCode());
					results.setProjects(empTechRatingDto.getProjects());
					results.setTechRating(new TechRating(empTechRatingDto.getTechRating().getTechName()));
					results.setTechRating(new TechRating(empTechRatingDto.getTechRating().getRating()));
					empTechRatingRepo.saveAll(getDetails);
				}
			}else {
				savedResults.hashCode();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return savedResults;
	}
	
	

}
