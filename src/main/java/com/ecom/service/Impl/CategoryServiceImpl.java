package com.ecom.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.domain.Category;
import com.ecom.repository.ICategoryRepository;
import com.ecom.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		Category addCategory = categoryRepository.save(category);
		return addCategory;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> getAllCate = categoryRepository.findAll();
		return getAllCate;
	}

	@Override
	public Boolean existCategory(String name) {
	boolean existByname =	categoryRepository.existsByName(name);
		
		return existByname;
	}

}
