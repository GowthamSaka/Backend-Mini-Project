package com.dtoexample.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmpTechRatingDto {
	
	private String empName;
	private String projects;
	private String experience;
	private String designation;
	private String empId;
	private String techName;
	
	
	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getProjects() {
		return projects;
	}


	public void setProjects(String projects) {
		this.projects = projects;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getTechName() {
		return techName;
	}


	public void setTechName(String techName) {
		this.techName = techName;
	}


	public EmpTechRatingDto() {
	}
	

	public EmpTechRatingDto(String empName, String projects, String experience, String designation, String empId, String techName) {
		super();
		this.empName = empName;
		this.projects = projects;
		this.experience = experience;
		this.designation = designation;
		this.empId = empId;
		this.techName = techName;
	}

}
