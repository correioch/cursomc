package com.ch.cursomc.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ch.cursomc.domain.Client;
import com.ch.cursomc.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private ClientService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Client> find(@PathVariable Integer id) {
		
		Client obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
