package com.caregiverproject.service;

import java.util.List;

import com.caregiverproject.entity.Caregiver;


public interface CaregiverService {

	public List<Caregiver> findAll();
	
	public Caregiver findById(int theId);
	
	public Caregiver save(Caregiver theCaregiver);
	
	public void deleteById(int theId);
}
