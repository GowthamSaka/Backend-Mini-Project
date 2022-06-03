package com.dtoexample.demo.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dtoexample.demo.dto.EmpTechRatingDto;
import com.dtoexample.demo.model.Designations;
import com.dtoexample.demo.model.Employee;
import com.dtoexample.demo.model.EmployeeSkills;
import com.dtoexample.demo.model.Projects;
import com.dtoexample.demo.model.TechRating;
import com.dtoexample.demo.model.TechnologyStack;
import com.dtoexample.demo.repository.EmployeeRepository;
import com.dtoexample.demo.repository.EmployeeSkillsRepository;
import com.dtoexample.demo.repository.TechRatingRepository;
import com.dtoexample.demo.service.EmployeeService;



@RestController
@RequestMapping("api/e1")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeSkillsRepository empSkillsRepo;
	
	@Autowired
	TechRatingRepository techRatingRepo;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/employees")
	public ResponseEntity<Map<String,String>> addEmployeeDetails(@Valid @RequestBody Employee employee) {
		employeeService.addEmployeeDetails(employee);
		Map<String,String> response= new HashMap<String,String>();
		response.put("Ok", "Success");
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("skillsofemployees")
	public boolean addEmployeeSkills(@RequestBody List<EmployeeSkills> skills) {
		return employeeService.addEmployeeSkills(skills);
	}
	
	
	@PostMapping("/saveemployees")
	public ResponseEntity<String> saveEmployeeDetails(@RequestBody List<Employee> empData) {
		employeeRepository.saveAll(empData);
		return ResponseEntity.ok("Data Success");
	}
	
	@GetMapping("/employees/{id}") 
	public Employee getvariablemethod(@PathVariable("id") int id) {
		Employee stu= employeeService.getemployee(id); 
		return stu;
	}
	
	@GetMapping("/allemployees")
    public ResponseEntity<List<Employee>> getAllEmployeess() {
        List<Employee> todos = employeeService.getEmployees();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
	
	@GetMapping("/allprojects")
	public ResponseEntity<List<Projects>> getAllProjects() {
		List<Projects> projects = employeeService.getAllProjects();
		return new ResponseEntity<>(projects,HttpStatus.OK);
	}
	
	@GetMapping("alldesignations")
	public ResponseEntity<List<Designations>> getAllDesignations() {
		List<Designations> designations = employeeService.getAllDesignations();
		return new ResponseEntity<>(designations,HttpStatus.OK);
	}
	
	@GetMapping("alltechnologies")
	public ResponseEntity<List<TechnologyStack>> getAllTechnologies() {
		List<TechnologyStack> technologies = employeeService.getAllTechnologies();
		return new ResponseEntity<>(technologies,HttpStatus.OK);
	}
	
	@GetMapping("alltechratings")
	public ResponseEntity<List<TechRating>> getAllTechnologyRatings() { 
		List<TechRating> techRating = employeeService.getAllTechnologyRatings();
		return new ResponseEntity<>(techRating,HttpStatus.OK);
	}
	
	
	@GetMapping("/requiredempdata")   
    @ResponseBody  
    public List<EmpTechRatingDto> getAllEmployeeTechnologies() {    
        List<EmpTechRatingDto> usersLocation = employeeService.getAllEmployeeTechnologies();   
        return usersLocation;  
    }
	
	@GetMapping("/byuser/{name}") 
	   public Employee getuserid(@PathVariable("name") String name) {
		   return employeeService.getuserid(name);
	}
	
	
//	@PostMapping("/skillsofemployees")
//	public boolean addEmployeeSkills(@RequestBody List<EmployeeSkills> skillsData) {
//		try {
//			for(EmployeeSkills skills : skillsData) {
//				empSkillsRepo.save(skills);
//			}
//			return true;
//		}catch(Exception e) {}
//		return false;
//	}
	
	
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Map<String,String>> updateEmployeeDetails(@Valid @RequestBody Employee employee, @PathVariable("id") int id) {
//		employeeService.updateemployeedetails(employee,id);
//		Map<String,String> response = new HashMap<String,String>();
//		response.put("Ok", "Updated");
//		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
//	}
//	
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<Map<String,String>> deleteEmployee(@PathVariable("id") int id) {
//		employeeService.deleteEmployee(id);
//		Map<String,String> response = new HashMap<String,String>();
//		response.put("Ok", "Deleted");
//		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
//	}
//	
//	
//	@GetMapping("/pagination")
//	public ResponseEntity<List<Employee>> getAllEmployeesPaging(
//			@RequestParam(defaultValue="0") Integer pageNo,
//			@RequestParam(defaultValue="5") Integer pageSize,
//			@RequestParam(defaultValue="id") String  sortBy) {
//		
//		List<Employee> list = employeeService.getEmployeesPages(pageNo,pageSize,sortBy);
//		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
//	}
	
	
//	@GetMapping("/search")
//    public ResponseEntity<List<Employee>> searchProducts(@RequestParam("query") String query){
//        return ResponseEntity.ok(employeeService.searchProducts(query));
//    }

}
