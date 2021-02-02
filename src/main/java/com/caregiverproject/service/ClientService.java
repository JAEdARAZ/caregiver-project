package com.caregiverproject.service;

import java.util.List;

import com.caregiverproject.entity.Caregiver;
import com.caregiverproject.entity.Client;


public interface ClientService {

	public List<Client> findAll();
	
	public Client findById(int theId);
	
	public Client save(Client theClient);
	
	public void deleteById(int theId);

	void addCaregiverToClient(int idCaregiver, int idClient);

	void deleteCaregiverFromClient(int idCaregiver, int idClient);

	List<Caregiver> getRemainingCaregivers(int idClient);

}
