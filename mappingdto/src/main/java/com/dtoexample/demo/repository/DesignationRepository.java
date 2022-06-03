package com.dtoexample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtoexample.demo.model.Designations;

public interface DesignationRepository extends JpaRepository<Designations,Integer>{

}
