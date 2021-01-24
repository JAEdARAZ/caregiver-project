package com.caregiverproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caregiverproject.dao.CaregiverRepository;
import com.caregiverproject.entity.Caregiver;

@RestController
public class CaregiverController {

	@Autowired
	private CaregiverRepository caregiverRepository;
	
	@GetMapping("/")
	public List<Caregiver> getCaregivers(){
		return caregiverRepository.findAll();
	}
	
}
