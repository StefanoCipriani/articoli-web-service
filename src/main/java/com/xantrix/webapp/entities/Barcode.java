package com.xantrix.webapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
public class Barcode {

	@Id
	private String barcode;
	private String idTipoArt;
	
	@ManyToOne
	@JoinColumn(name = "COD_ART")
	@JsonBackReference
	private Articoli articolo;

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getIdTipoArt() {
		return idTipoArt;
	}

	public void setIdTipoArt(String idTipoArt) {
		this.idTipoArt = idTipoArt;
	}

	public Articoli getArticolo() {
		return articolo;
	}

	public void setArticolo(Articoli articolo) {
		this.articolo = articolo;
	}
	
	
}
