package com.caregiverproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caregiverproject.dao.ClientRepository;
import com.caregiverproject.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;
	
	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
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

}
