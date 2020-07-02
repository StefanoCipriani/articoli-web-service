package com.xantrix.webapp.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import com.xantrix.webapp.entities.Articoli;

public interface ArticoliService
{
	public Iterable<Articoli> selTutti();
	
	public List<Articoli> selByDescrizione(String descrizione);
		
	public List<Articoli> selByDescrizione(String descrizione, Pageable pageable);
	
	public Articoli selByCodArt(String codArt);
	
	public void delArticolo(Articoli articolo);
	
	public void insArticolo(Articoli articolo);
	 
}
