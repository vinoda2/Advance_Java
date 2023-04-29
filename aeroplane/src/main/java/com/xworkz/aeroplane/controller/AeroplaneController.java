package com.xworkz.aeroplane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AeroplaneController {
	
	@PostMapping("/save")
	public String onSave() {
		System.out.println("this is save method");
		return "index";
	}
	

}
