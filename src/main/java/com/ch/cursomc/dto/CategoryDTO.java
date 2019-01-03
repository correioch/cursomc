package com.ch.cursomc.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.ch.cursomc.domain.Category;

public class CategoryDTO {
	
	private Integer id;
	@NotEmpty(message="Pas possible etre vide")
	@Length(min=5, max=80, message="La taile doit etre entre 5 et 80 lettres")
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
