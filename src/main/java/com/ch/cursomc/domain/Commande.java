package com.ch.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Commande implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private Date instant;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="commande")
	private Payment payement;
	
	@ManyToOne
	@JoinColumn(name="adresse_livraison_id")
	private Adresse adresseLivraison;
	
	@OneToMany(mappedBy="id.commande")
    Set<ArticleCommande> article = new HashSet<>();
	
	public List<Product> getArticles(){
		
		List<Product> liste = new ArrayList<Product>();
		for(ArticleCommande x: article) {
			liste.add(x.getProduit());
		}
		
		return liste;
	}
    
	public Set<ArticleCommande> getArticle() {
		return article;
	}

	public void setArticle(Set<ArticleCommande> article) {
		this.article = article;
	}

	public Commande() {
		// TODO Auto-generated constructor stub
	}
	
	public Commande(Integer id, Date instant, Client client, Adresse adresseLivraison) {
		super();
		Id = id;
		this.instant = instant;
		this.client = client;
		this.adresseLivraison = adresseLivraison;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Payment getPayement() {
		return payement;
	}

	public void setPayement(Payment payement) {
		this.payement = payement;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Date getInstant() {
		return instant;
	}
	public void setInstant(Date instant) {
		this.instant = instant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		Commande other = (Commande) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
	

}
