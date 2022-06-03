package com.dtoexample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dtoexample.demo.dto.EmployeeTechRatingDTO;
import com.dtoexample.demo.service.EmployeeTechRatingDTOService;

@RestController
public class EmployeeTechRatingDTOController {
	
	@Autowired
	private EmployeeTechRatingDTOService empTechRagingDtoService;
	
	@PostMapping("/saveemployees")
	public EmployeeTechRatingDTO saveEmployeeDetailsRequired(@RequestBody EmployeeTechRatingDTO empTechRagingDto) {
		return empTechRagingDtoService.saverating(empTechRagingDto);
	}

}
