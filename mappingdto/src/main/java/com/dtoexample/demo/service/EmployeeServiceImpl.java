package com.dtoexample.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dtoexample.demo.dto.EmpTechRatingDto;
import com.dtoexample.demo.model.Designations;
import com.dtoexample.demo.model.Employee;
import com.dtoexample.demo.model.EmployeeSkills;
import com.dtoexample.demo.model.Projects;
import com.dtoexample.demo.model.TechRating;
import com.dtoexample.demo.model.TechnologyStack;
import com.dtoexample.demo.repository.DesignationRepository;
import com.dtoexample.demo.repository.EmployeeRepository;
import com.dtoexample.demo.repository.EmployeeSkillsRepository;
import com.dtoexample.demo.repository.ProjectsRepository;
import com.dtoexample.demo.repository.TechRatingRepository;
import com.dtoexample.demo.repository.TechnologyStackRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectsRepository projectsRepository;
	
	@Autowired
	DesignationRepository designationRepository;
	
	@Autowired
	TechRatingRepository techRatingRepository;
	
	@Autowired
	TechnologyStackRepository techStackRepo;
	
	@Autowired
	EmployeeSkillsRepository empSkillsRepo;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee addEmployeeDetails(Employee employee) {
		return employeeRepository.save(employee);
	}
	

	@Override
	public Employee getemployee(int id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(); 
		return employee;
	}

	@Override
	public Employee updateemployeedetails(Employee employee, int id) {
		Employee emps = employeeRepository.findById(id).orElseThrow();
		emps.setEmpId(employee.getEmpId());
		emps.setEmpName(employee.getEmpName());
		emps.setDesignation(employee.getDesignation());
		emps.setExperience(employee.getExperience());
		emps.setProjects(employee.getProjects());
		Employee emupdate = employeeRepository.save(emps);
		return emupdate;
	}

	@Override
	public void deleteEmployee(int id) {
	  employeeRepository.deleteById(id);
	}


	@Override
	public List<Employee> getEmployees() {
		List<Employee> emp = employeeRepository.findAll();
		return emp;
	}
	

	@Override
	public List<Employee> getEmployeesPages(Integer pageNo, Integer pageSize, String sortBy) {
		PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Employee> pagedResult = employeeRepository.findAll(paging);
		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		}else {
			return new ArrayList<Employee>();
		}
	}

//	@Override
//    public List<Employee> searchProducts(String query) {
//        List<Employee> products = employeeRepository.searchProducts(query);
//        return products;
//    }

	

//	@Override
//	public List<EmpTechRatingDto> getAllEmployeeTechnologies() {
//		List<EmpTechRatingDto> empTechDtoList = new ArrayList<>();
//		try {
//			List<Employee> employeeList = employeeRepository.findAll();
//			if (!employeeList.isEmpty()) {
//				employeeList.forEach(emp -> {
//					EmpTechRatingDto employeeDtlsDTO = new EmpTechRatingDto();
//					employeeDtlsDTO.setEmpName(emp.getEmpName());
//					employeeDtlsDTO.setEmpId(emp.getEmpId());
////					employeeDtlsDTO.setEmpRegisterId(emp.getEmpRegisterId());
//					employeeDtlsDTO.setExperience(emp.getExperience());
//					employeeDtlsDTO.setProjects(emp.getProjects());
//					employeeDtlsDTO.setDesignation(emp.getDesignation());
//					//employeeDtlsDTO.setTechRating(emp.);
//					
//				//	employeeDtlsDTO.setTechName(emp.ge)
//					//TechRating techList = techRatingRepository.findByEmpRegisterId(emp.getEmpRegisterId());
//					//techList.forEach(tech -> {
//					//employeeDtlsDTO.setTechName(techList.getTechName());
//					//});
//					List<TechRating> techList = techRatingRepository.findAll();
//					techList.forEach(tech -> {
//						employeeDtlsDTO.setTechName(tech.getTechName());
//						employeeDtlsDTO.setRating(tech.getRating());
//					});
//					
//					empTechDtoList.add(employeeDtlsDTO);
//				});
//			} 
//		} catch (Exception e) {
//		}
//		return empTechDtoList;
//	}



	@Override
	public List<Projects> getAllProjects() {
		List<Projects> proj = projectsRepository.findAll();
		return proj;
	}

	@Override
	public List<Designations> getAllDesignations() {
		List<Designations> desig = designationRepository.findAll();
		return desig;
	}


	@Override
	public List<TechnologyStack> getAllTechnologies() {
		List<TechnologyStack> techs = techStackRepo.findAll();
		return techs;
	}

	@Override
	public List<TechRating> getAllTechnologyRatings() {
		List<TechRating> techsrating = techRatingRepository.findAll();
		return techsrating;
	}

	@Override
	public List<EmpTechRatingDto> getAllEmployeeTechnologies() {
		List<EmpTechRatingDto> EmployeeDetails = new ArrayList<>();
		try {
			List<EmployeeSkills> SkillsDetails = empSkillsRepo.findAll();
			if(EmployeeDetails != null) {
				for(EmployeeSkills data : SkillsDetails) {
					EmpTechRatingDto techRatingDto = new EmpTechRatingDto();
					techRatingDto.setTechName(data.getTechName());
					techRatingDto.setEmpName(data.getEmployee().getEmpName());
					techRatingDto.setEmpId(data.getEmployee().getEmpId());
					techRatingDto.setDesignation(data.getEmployee().getDesignation());
					techRatingDto.setProjects(data.getEmployee().getProjects());
					techRatingDto.setExperience(data.getEmployee().getExperience());
					EmployeeDetails.add(techRatingDto);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return EmployeeDetails;
	}


	@Override
	public boolean addEmployeeSkills(List<EmployeeSkills> skills) {
		try {
			for(EmployeeSkills skill : skills) {
				EmployeeSkills skillData = new EmployeeSkills();
				skillData.setRating(skill.getRating());
				skillData.setTechName(skill.getTechName());
				skillData.setEmployee(new Employee(skill.getEmployee().getEmpRegisterId()));
				skillData.setEmployee(new Employee(skill.getEmployee().getEmpId()));
				empSkillsRepo.save(skillData);
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee getuserid(String name) {
		return employeeRepository.findByEmpName(name);
	}


}
