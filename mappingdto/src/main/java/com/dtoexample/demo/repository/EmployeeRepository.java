package com.dtoexample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtoexample.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
//	 @Query("SELECT p FROM Employee p WHERE " +
//	            "p.empName LIKE CONCAT('%',:query, '%')" +
//	            "Or p.projects LIKE CONCAT('%', :query, '%')")
//	    List<Employee> searchProducts(String query);
//	 


	Employee findByEmpName(String name);
	 

}
