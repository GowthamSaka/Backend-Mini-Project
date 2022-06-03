package com.dtoexample.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.dtoexample.demo.dto.EmpTechRatingDto;
import com.dtoexample.demo.model.Designations;
import com.dtoexample.demo.model.Employee;
import com.dtoexample.demo.model.EmployeeSkills;
import com.dtoexample.demo.model.Projects;
import com.dtoexample.demo.model.TechRating;
import com.dtoexample.demo.model.TechnologyStack;


public interface EmployeeService {

	public Employee getemployee(int id);

	public Employee updateemployeedetails(Employee employee, int id);

	public void deleteEmployee(int id);

	public List<Employee> getEmployees();

	public List<Employee> getEmployeesPages(Integer pageNo, Integer pageSize, String sortBy);
	
	//List<Employee> searchProducts(String query);

	public Employee addEmployeeDetails(@Valid Employee employee);

	public List<EmpTechRatingDto> getAllEmployeeTechnologies();

	public List<Projects> getAllProjects();

	public List<Designations> getAllDesignations();

	public List<TechnologyStack> getAllTechnologies();

	List<TechRating> getAllTechnologyRatings();

	public boolean addEmployeeSkills(List<EmployeeSkills> skills);

	public Employee getuserid(String name);




//	public List<TechnologyStack> getAllTechnologies();


	
}
