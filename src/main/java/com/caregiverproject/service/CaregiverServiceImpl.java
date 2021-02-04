package com.caregiverproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caregiverproject.dao.CaregiverRepository;
import com.caregiverproject.entity.Caregiver;

@Service
public class CaregiverServiceImpl implements CaregiverService {

	private CaregiverRepository caregiverRepository;
	
	@Autowired
	public CaregiverServiceImpl(CaregiverRepository caregiverRepository) {
		this.caregiverRepository = caregiverRepository;
	}
	
	@Override
	public List<Caregiver> findAll() {
		return caregiverRepository.findAll();
	}

	@Override
	public Caregiver findById(int theId) {
		Optional<Caregiver> result = caregiverRepository.findById(theId);
		
		Caregiver caregiver = null;
		if(result.isPresent()) {
			caregiver = result.get();
		}
		
		return caregiver;
	}

	@Override
	public Caregiver save(Caregiver theCaregiver) {
		System.out.println(">>> save caregiver: " + theCaregiver.toString());
		return caregiverRepository.save(theCaregiver);
	}

	@Override
	public void deleteById(int theId) {
		caregiverRepository.deleteById(theId);
	}

}
