package com.ch.cursomc.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ch.cursomc.domain.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@RequestMapping(method=RequestMethod.GET)
	public List<Category> list() {
		
		Category cat1 = new Category(1, "Informatique");
		Category cat2 = new Category(1, "Marketinig");
		
		List <Category> listCategory = new ArrayList<>();
		listCategory.add(cat1);
		listCategory.add(cat2);
		
		return listCategory;
	}

}
