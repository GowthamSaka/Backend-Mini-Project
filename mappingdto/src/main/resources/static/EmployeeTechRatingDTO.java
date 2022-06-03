package com.dtoexample.demo.dto;

import com.dtoexample.demo.model.TechRating;

import lombok.Data;

@Data
public class EmployeeTechRatingDTO {
	
	private String empName;
	private String empCode;
	private String projects;
	
	private TechRating techRating;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	public TechRating getTechRating() {
		return techRating;
	}

	public void setTechRating(TechRating techRating) {
		this.techRating = techRating;
	}

	public EmployeeTechRatingDTO(String empName, String empCode, String projects, TechRating techRating) {
		super();
		this.empName = empName;
		this.empCode = empCode;
		this.projects = projects;
		this.techRating = techRating;
	}

	public EmployeeTechRatingDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeTechRatingDTO [empName=" + empName + ", empCode=" + empCode + ", projects=" + projects
				+ ", techRating=" + techRating + "]";
	}
	
	
	
	

}
