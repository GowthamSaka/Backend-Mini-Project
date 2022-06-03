package com.dtoexample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtoexample.demo.model.Projects;

public interface ProjectsRepository extends JpaRepository<Projects,Integer>{

}
