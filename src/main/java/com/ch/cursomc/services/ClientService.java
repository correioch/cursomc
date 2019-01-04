package com.ch.cursomc.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ch.cursomc.domain.Adresse;
import com.ch.cursomc.domain.Client;
import com.ch.cursomc.domain.ClientNewDTO;
import com.ch.cursomc.domain.Ville;
import com.ch.cursomc.domain.enums.TypeClient;
import com.ch.cursomc.dto.ClientDTO;
import com.ch.cursomc.repositories.AdresseRepository;
import com.ch.cursomc.repositories.ClientRepository;
import com.ch.cursomc.services.exception.DataIntegrityViolationException;
import com.ch.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo; 
	
	@Autowired
	private AdresseRepository adresseRepo; 
	
	public Client find(Integer id) {
		
		Optional<Client> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> 
			new ObjectNotFoundException("Objet pas trouve! id: " + id + ", Tipo: " + 
				Client.class.getName()));
	}
	
	@Transactional
	public Client insert (Client obj) {
		obj.setId(null);
		obj = repo.save(obj);
		adresseRepo.saveAll(obj.getAdresses());
		return obj;
	}
	
	public Client update(Client obj) {
		Client newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Il n'est pas possible effacer un categorie avec produit");
		}
	}
	
	public List<Client> findAll(){
		return repo.findAll();
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);	
	}
	
	public Client fromDTO (ClientDTO objDto){
		return new Client	(objDto.getId(), objDto.getNom(), objDto.getEmail(), null, null);
	}
	
	public Client fromDTO (ClientNewDTO objDto){
		Client cli = new Client	(null, objDto.getNom(), objDto.getEmail(), objDto.getCodIdentification(), TypeClient.toEnum(objDto.getTypeClient()));
		Ville ville = new Ville(objDto.getCidadeId(), null, null);
		Adresse adr = new Adresse(null, objDto.getRue(), objDto.getNumero(), objDto.getComplement(), objDto.getCartier(), objDto.getCep(), cli, ville);
		cli.getAdresses().add(adr);
		cli.getTelephones().add(objDto.getTelephone1());
		if(objDto.getTelephone2()!= null) {
			cli.getTelephones().add(objDto.getTelephone2());
		}
		if(objDto.getTelephone3()!= null) {
			cli.getTelephones().add(objDto.getTelephone3());
		}
		return cli;
	}
	
	private void updateData(Client newObj, Client obj) {
		newObj.setNom(obj.getNom());
		newObj.setEmail(obj.getEmail());
	}
	
}
