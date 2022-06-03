package com.dtoexample.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtoexample.demo.dto.EmployeeTechRatingDTO;
import com.dtoexample.demo.model.Employee;

public interface EmployeeTechRatingDTORepository extends JpaRepository<EmployeeTechRatingDTO, Integer>{

	void saveAll(List<Employee> getDetails);

}
