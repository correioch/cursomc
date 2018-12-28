package com.ch.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.cursomc.domain.Client;
import com.ch.cursomc.repositories.ClientRepository;
import com.ch.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo; 
	
	public Client find(Integer id) {
		
		Optional<Client> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> 
			new ObjectNotFoundException("Objet pas trouve! id: " + id + ", Tipo: " + 
				Client.class.getName()));
	}
	
}
