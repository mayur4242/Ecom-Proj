package com.ecom.service;

import java.util.List;

import com.ecom.domain.Category;


public interface ICategoryService {
	
	public Category saveCategory(Category category);
	
	public List<Category> getAllCategory();
	
	public Boolean existCategory(String name);
}
