package com.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String homePage() {
		
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage(){
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/products")
	public String productsGet() {
		return "products";
	}
	

	@GetMapping("/viewproduct")
	public String viewProduct() {
		
		return "view_product";
	}

	

}
