package com.ch.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.cursomc.domain.Commande;
import com.ch.cursomc.repositories.CommandeRepository;
import com.ch.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository repo; 
	
	public Commande find(Integer id) {
		
		Optional<Commande> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> 
			new ObjectNotFoundException("Objet pas trouve! id: " + id + ", Tipo: " + 
				Commande.class.getName()));
	}
	
}
