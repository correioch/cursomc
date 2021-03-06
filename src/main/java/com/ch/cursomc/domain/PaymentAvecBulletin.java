package com.ch.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.ch.cursomc.domain.enums.EtatPayment;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PaymentAvecBulletin extends Payment{
	
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateExpiration;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date datePayment;
	
	public PaymentAvecBulletin() {
		// TODO Auto-generated constructor stub
	}

	public PaymentAvecBulletin(Integer id, EtatPayment etatPayment, Commande commande, Date dateExpriration, Date datePayment) {
		super(id, etatPayment, commande);
		this.dateExpiration = dateExpriration;
		this.datePayment = datePayment;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}
	
	
   

}
