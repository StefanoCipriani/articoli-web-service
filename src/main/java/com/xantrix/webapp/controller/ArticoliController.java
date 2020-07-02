package com.xantrix.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.entities.Barcode;
import com.xantrix.webapp.exception.NotFoundException;
import com.xantrix.webapp.service.BarcodeService;

@RestController
@RequestMapping("/api/articoli")
public class ArticoliController {

	private static final Logger logger = LoggerFactory.getLogger(ArticoliController.class);
	
	@Autowired
	BarcodeService barcodeService;
	
	@GetMapping(value = "cerca/ean/{barcode}", produces = "application/json")
	public ResponseEntity<Articoli> listArtByEan(@PathVariable("barcode") String barcode)
		throws NotFoundException
	{
		logger.info("********** Otteniamo l'articolo con barcode: {} **********", barcode);
		Articoli articolo = null;
		Barcode ean = barcodeService.selByBarcode(barcode);
		
		if(ean == null) {
			String errMsg = String.format("Il barcode %s non è stato trovato!", barcode);
			logger.warn(errMsg);
			throw new NotFoundException(errMsg);
			//return new ResponseEntity<Articoli>(HttpStatus.NOT_FOUND);
		}else {
			articolo = ean.getArticolo();
			return new ResponseEntity<Articoli>(articolo,HttpStatus.OK);
		}
	}
}
