package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.domain.Category;
import com.ecom.service.Impl.CategoryServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CategoryServiceImpl categoryService;

	@GetMapping("/")
	public String index() {

		return "admin/index";
	}

	@GetMapping("/addproduct")
	public String addProduct() {

		return "admin/add_product";
	}

	@GetMapping("/category")
	public String categoryPage(HttpSession session, Model model) {
		model.addAttribute("message", session.getAttribute("message"));
		model.addAttribute("errormessage", session.getAttribute("errormessage"));

		// Explicitly remove session messages to prevent persistence
		session.removeAttribute("message");
		session.removeAttribute("errormessage");

		return "admin/category";
	}

	@PostMapping("/savecategory")
	public String saveCategory(@ModelAttribute Category category, @RequestParam("categoryIcon") MultipartFile file,
			HttpSession session) {

		String imageName = file != null && !file.isEmpty() ? file.getOriginalFilename() : "default.jpg";
		category.setImageName(imageName);

		Boolean existCategory = categoryService.existCategory(category.getName());

		if (existCategory) {
			session.setAttribute("errormessage", "Category already exists");
		} else {
			Category savedCategory = categoryService.saveCategory(category);

			if (ObjectUtils.isEmpty(savedCategory)) {
				session.setAttribute("errormessage", "Not saved.. Internal server error");
			} else {
				session.setAttribute("message", "Saved Category");
			}
		}

		return "redirect:/admin/category";
	}

}
