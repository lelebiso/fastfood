package it.pegaso2000.fastFoodApi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import it.pegaso2000.fastFoodApi.dto.ClienteDto;
import it.pegaso2000.fastFoodApi.model.Cliente;
import it.pegaso2000.fastFoodApi.service.ClienteService;

public class ClienteController {
	
	private ClienteService service;

	@Autowired
	public ClienteController(ClienteService service) {
		super();
		this.service = service;
	}
	
	private ClienteDto entityToDto(Cliente c) {
		ClienteDto dto = new ClienteDto();
		dto.setId(c.getId());
		dto.setNome(c.getNome());
		dto.setIs_vegetariano(c.isIs_vegetariano());
		dto.setEta(c.getEta());
		return dto;
	}
}
