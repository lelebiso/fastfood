package it.pegaso2000.fastFoodApi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import it.pegaso2000.fastFoodApi.dto.PiattoDto;
import it.pegaso2000.fastFoodApi.model.Piatto;
import it.pegaso2000.fastFoodApi.service.PiattoService;

public class PiattoController {
	
	private PiattoService service;

	@Autowired
	public PiattoController(PiattoService service) {
		super();
		this.service = service;
	}
	
	private PiattoDto entityToDto(Piatto p) {
		PiattoDto dto = new PiattoDto();
		dto.setId(p.getId());
		dto.setIs_vegetariano(p.isIs_vegetariano());
		dto.setDescrizione(p.getDescrizione());
		dto.setPrezzo(p.getPrezzo());
		return dto;
	}
}
