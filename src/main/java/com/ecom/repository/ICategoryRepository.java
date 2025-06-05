package com.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.domain.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer>{
	
	Boolean existsByName(String name);

}
