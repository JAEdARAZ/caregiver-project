package com.caregiverproject.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caregiverproject.dao.ClientRepository;
import com.caregiverproject.entity.Caregiver;
import com.caregiverproject.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;
	private CaregiverService caregiverService;
	
	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository, CaregiverService caregiverService) {
		this.clientRepository = clientRepository;
		this.caregiverService = caregiverService;
	}
	
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client findById(int theId) {
		Optional<Client> result = clientRepository.findById(theId);
		
		Client theClient = null;
		if(result.isPresent()) {
			theClient = result.get();
		}
		
		return theClient;
	}

	@Override
	public Client save(Client theClient) {
		return clientRepository.save(theClient);
	}

	@Override
	public void deleteById(int theId) {
		clientRepository.deleteById(theId);
	}
	
	@Override
	public void addCaregiverToClient(int idCaregiver, int idClient) {
        Client client = this.findById(idClient);
        Caregiver caregiver = caregiverService.findById(idCaregiver);

        if (client != null) {
        	client.addCaregiver(caregiver);
        	clientRepository.save(client);
        }
    }
	
	@Override
	public void deleteCaregiverFromClient(int idCaregiver, int idClient) {
		Client client = this.findById(idClient);
        Caregiver caregiver = caregiverService.findById(idCaregiver);
        
        client.deleteCaregiver(caregiver);
        clientRepository.save(client);
	}
	
	@Override
	public List<Caregiver> getRemainingCaregivers(int idClient){
		List<Caregiver> caregivers = caregiverService.findAll();
		
		Client client = this.findById(idClient);
		Set<Caregiver> clientCaregivers = client.getCaregivers();
		
		for(Caregiver c : clientCaregivers) {
			caregivers.remove(c);
		}
		
		return caregivers.size() > 0 ? caregivers : null;
	}

}
