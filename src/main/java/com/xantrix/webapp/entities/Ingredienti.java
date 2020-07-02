package com.xantrix.webapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredienti {

	@Id
	private String id;
	@OneToOne
	//@JoinColumn(name = "COD_ART")
	@PrimaryKeyJoinColumn
	private Articoli articolo;
}
