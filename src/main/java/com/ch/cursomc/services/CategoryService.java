package com.ch.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.cursomc.domain.Category;
import com.ch.cursomc.repositories.CategoryRepository;
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
	
}
