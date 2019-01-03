package com.ch.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ch.cursomc.domain.Category;
import com.ch.cursomc.dto.CategoryDTO;
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
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);	
	}
	
	public Category fromDTO (CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getNome());
	}
}
