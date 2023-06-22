package it.pegaso2000.fastFoodApi.service;

import java.util.List;

import it.pegaso2000.fastFoodApi.model.Cliente;

public interface ClienteService {
	
	List<Cliente> findAll();
	Cliente save(Cliente cliente);
	Cliente findById (int id);
	boolean delete (int id);
}
