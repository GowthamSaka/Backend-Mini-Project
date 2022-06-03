package com.dtoexample.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employeeskills")
public class EmployeeSkills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	
//	private String empId;
	private String techName;
	private String rating;
	@ManyToOne
	@JoinColumn(name="emp_register_id")
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
//	public String getEmpId() {
//		return empId;
//	}
//	public void setEmpId(String empId) {
//		this.empId = empId;
//	}
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public EmployeeSkills(int skillId, String techName, String rating) {
		super();
		this.skillId = skillId;
//		this.empId = empId;
		this.techName = techName;
		this.rating = rating;
	}
	
	public EmployeeSkills() {
		
	}

}
