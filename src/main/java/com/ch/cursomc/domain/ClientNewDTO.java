package com.ch.cursomc.domain;

import java.io.Serializable;

public class ClientNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	private String nom;
	private String email;
	private String codIdentification;
	private Integer typeClient;
	
	private String rue;
	private String numero;
	private String complement;
	private String cartier;
	private String cep;
	
	private String telephone1;
	private String telephone2;
	private String telephone3;
	
	private Integer cidadeId;

	public ClientNewDTO() {
		// TODO Auto-generated constructor stub
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

	public String getCodIdentification() {
		return codIdentification;
	}

	public void setCodIdentification(String codIdentification) {
		this.codIdentification = codIdentification;
	}

	public Integer getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(Integer typeClient) {
		this.typeClient = typeClient;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCartier() {
		return cartier;
	}

	public void setCartier(String cartier) {
		this.cartier = cartier;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getTelephone3() {
		return telephone3;
	}

	public void setTelephone3(String telephone3) {
		this.telephone3 = telephone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	
	
}
