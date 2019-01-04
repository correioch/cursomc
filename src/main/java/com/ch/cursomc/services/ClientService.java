package com.ch.cursomc.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.NotSupportedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ch.cursomc.domain.Client;
import com.ch.cursomc.dto.ClientDTO;
import com.ch.cursomc.repositories.ClientRepository;
import com.ch.cursomc.services.exception.DataIntegrityViolationException;
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
	
	public Client fromDTO (ClientDTO objDto) throws NotSupportedException {
		return new Client	(objDto.getId(), objDto.getNom(), objDto.getEmail(), null, null);
	}
	
	private void updateData(Client newObj, Client obj) {
		newObj.setNom(obj.getNom());
		newObj.setEmail(obj.getEmail());
	}
	
}
