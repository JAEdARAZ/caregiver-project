package com.caregiverproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caregiverproject.entity.Caregiver;
import com.caregiverproject.service.CaregiverService;

@Controller
@RequestMapping("/caregivers")
public class CaregiverController {

	private CaregiverService caregiverService;
	
	@Autowired
	public CaregiverController(CaregiverService caregiverService) {
		this.caregiverService = caregiverService;
	}
	
	
	@GetMapping("/caregiverForm")
	public String showCaregiverForm(Model theModel) {
		theModel.addAttribute("caregiver", new Caregiver());
		
		return "forms/caregiver-form";
	}
	
	@PostMapping("/save")
	public String saveCaregiver(@ModelAttribute Caregiver theCaregiver) {
		caregiverService.save(theCaregiver);
		
		return "redirect:/mainMenu";
	}
}
