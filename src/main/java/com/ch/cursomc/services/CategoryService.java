package com.ch.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.cursomc.domain.Category;
import com.ch.cursomc.repositories.CategoryRepository;
import com.ch.cursomc.services.exception.DataIntegrityViolationException;
import com.ch.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo; 
	
	public Category find(Integer id) {
		
		Optional<Category> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> 
			new ObjectNotFoundException("Objet pas trouve! id: " + id + ", Tipo: " + 
				Category.class.getName()));
	}
	
	public Category insert (Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Category update(Category obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Il n'est pas possible effacer un categorie avec produit");
		}
	}
	
	public List<Category> findAll(){
		return repo.findAll();
	}
}
