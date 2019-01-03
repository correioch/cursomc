package com.ch.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.ch.cursomc.domain.Client;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Champ obrigatoire")
	@Length(min=5, max=120, message="La taille du champ doit etre entre 5 et 120")
	private String nom;
	@NotEmpty(message = "Champ obrigatoire")
	@Email(message="courriel invalid")
	private String email;
	
	public ClientDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ClientDTO(Client obj) {
		id = obj.getId();
		nom = obj.getNom();
		email = obj.getEmail();
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
