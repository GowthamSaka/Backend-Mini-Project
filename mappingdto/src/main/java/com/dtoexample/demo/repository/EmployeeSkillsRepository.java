package com.dtoexample.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtoexample.demo.model.EmployeeSkills;

public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, Integer> {
	List<EmployeeSkills> findAll();	
}
