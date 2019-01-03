package com.ch.cursomc.dto;

import com.ch.cursomc.domain.Category;

public class CategoryDTO {
	
	private Integer id;
	private String nome;
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CategoryDTO(Category obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
