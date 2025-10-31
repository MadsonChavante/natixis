package com.exercise.natixis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.natixis.dto.ClientDTO;
import com.exercise.natixis.entity.Client;
import com.exercise.natixis.exceptions.DuplicateObjectException;
import com.exercise.natixis.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client save(ClientDTO clientDTO) {
        Client newClient = new Client(clientDTO);

		Optional<Client> client = repository.findByNif(newClient.getNif());
		if(client.isPresent()){
			throw new DuplicateObjectException("Client already registered with this nif.");
		}  
        
		return repository.save(newClient);
	}

    public List<Client> findAll() {
		return repository.findAll();
	}
    
}
