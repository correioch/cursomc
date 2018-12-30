package com.ch.cursomc.domain;

import javax.persistence.Entity;

import com.ch.cursomc.domain.enums.EtatPayment;

@Entity
public class PaymentAvecCarte extends Payment{

	private static final long serialVersionUID = 1L;
	private Integer nombreParcelles;
	
	public PaymentAvecCarte() {
		// TODO Auto-generated constructor stub
	}

	public PaymentAvecCarte(Integer id, EtatPayment etatPayment, 
			Commande commande, Integer nombreParcelles) {
		super(id, etatPayment, commande);
		this.nombreParcelles = nombreParcelles;
	}

	public Integer getNombreParcelles() {
		return nombreParcelles;
	}

	public void setNombreParcelles(Integer nombreParcelles) {
		this.nombreParcelles = nombreParcelles;
	}
	
	
}
