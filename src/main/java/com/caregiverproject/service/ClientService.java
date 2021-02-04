package com.caregiverproject.service;

import java.util.List;

import com.caregiverproject.entity.Caregiver;
import com.caregiverproject.entity.Client;
import com.caregiverproject.entity.Task;


public interface ClientService {

	public List<Client> findAll();
	
	public Client findById(int theId);
	
	public Client save(Client theClient);
	
	public void deleteById(int theId);

	void addCaregiverToClient(int idCaregiver, int idClient);

	void deleteCaregiverFromClient(int idCaregiver, int idClient);

	List<Caregiver> getRemainingCaregivers(int idClient);

	void deleteTaskFromClient(int idTask, int idClient);

	public void addTaskToClient(int idClient, Task task);

}
