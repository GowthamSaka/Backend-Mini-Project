package com.dtoexample.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Transactional
@NoArgsConstructor
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_register_id")
	private int empRegisterId;
	
	@Column(name="empid")
	private String empId;
	
	@Column(name="empname")
	@NotEmpty
	@Size(min=2,message="EmployeeName should have atleast 2 characters")
	private String empName;
	
	@NotEmpty
	private String designation;
	
	@NotEmpty
	private String experience;
	
	@NotEmpty
	private String projects;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="fk_emp_id",referencedColumnName = "emp_register_id")
//	private List<TechRating> techRating;
//	
	

	public int getEmpRegisterId() {
		return empRegisterId;
	}

	public void setEmpRegisterId(int empRegisterId) {
		this.empRegisterId = empRegisterId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

//	public List<TechRating> getTechRating() {
//		return techRating;
//	}
//
//	public void setTechRating(List<TechRating> techRating) {
//		this.techRating = techRating;
//	}

	public Employee(int empRegisterId, String empId,
			@NotEmpty @Size(min = 2, message = "EmployeeName should have atleast 2 characters") String empName,
			@NotEmpty String designation, @NotEmpty String experience, @NotEmpty String projects) {
		super();
		this.empRegisterId = empRegisterId;
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.experience = experience;
		this.projects = projects;
//		this.techRating = techRating;
	}

	@Override
	public String toString() {
		return "Employee [empRegisterId=" + empRegisterId + ", empId=" + empId + ", empName=" + empName
				+ ", designation=" + designation + ", experience=" + experience + ", projects=" + projects + "]";
	}
	
	public Employee(String empId) {
		this.empId = empId;
	}

	public Employee(int empRegisterId) {
		this.empRegisterId = empRegisterId;
	}
	
	public Employee() {
		
	}

	
}
