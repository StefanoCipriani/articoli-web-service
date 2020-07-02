package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.xantrix.webapp.entities.Articoli;

public interface ArticoliRepository extends PagingAndSortingRepository<Articoli, String>{

	public List<Articoli> findByDescrizioneLike(String string);
	
	public List<Articoli> findByDescrizioneLike(String string, Pageable pageble);

	public Articoli findByCodArt(String string);
}
