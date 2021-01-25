package com.caregiverproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	@GetMapping("/mainMenu")
	public String mainMenu(){
		return "main-menu";
	}
}
