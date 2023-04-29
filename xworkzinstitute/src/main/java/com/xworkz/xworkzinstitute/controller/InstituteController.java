package com.xworkz.xworkzinstitute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InstituteController {
	public InstituteController() {
		System.out.println("InstituteController");
	}
	
	@PostMapping("register")
	public String onRgister() {
		System.out.println("this is onRegister method");
		return "index";
	}g
}
