package com.ch.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ArticleCommande implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArticleComandePK id = new ArticleComandePK();
	
	private Double rabais;
	private Integer quantite;
	private Double prix;
	
	public ArticleCommande() {

	}

	public ArticleCommande(Product produit, Commande commande, Double rabais, Integer quantite, Double prix) {
		super();
		id.setProduit(produit);
		id.setCommande(commande);
		this.rabais = rabais;
		this.quantite = quantite;
		this.prix = prix;
	}

	public Commande getCommande() {
		return id.getCommande();
	}
	
	public Product getProduit(){
		return id.getProduit();
	}
	
	public ArticleComandePK getId() {
		return id;
	}

	public void setId(ArticleComandePK id) {
		this.id = id;
	}

	public Double getRabais() {
		return rabais;
	}

	public void setRabais(Double rabais) {
		this.rabais = rabais;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleCommande other = (ArticleCommande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
		
	
	
}
