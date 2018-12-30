package com.ch.cursomc.domain.enums;

public enum EtatPayment {
	
	EN_ATTENTE(1, "En Attente"),
	ENLEVE(2, "Enleve"),
	ANNULE(3, "Annule");

	private int cod;
	private String description;
	
	private EtatPayment (int cod, String description) {
		
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	public String getDescription() {
		return description;
	}

	public static EtatPayment toEnum (Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for(EtatPayment x : EtatPayment.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalide: " + cod);
	}
}
