package com.dtoexample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtoexample.demo.model.TechRating;

public interface TechRatingRepository extends JpaRepository<TechRating, Integer>{

	TechRating findByEmpRegisterId(int empRegisterId);

}
