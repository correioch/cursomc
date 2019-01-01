package com.ch.cursomc.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ch.cursomc.domain.Commande;
import com.ch.cursomc.services.CommandeService;

@RestController
@RequestMapping(value="/commandes")
public class CommandeResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private CommandeService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Commande obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
