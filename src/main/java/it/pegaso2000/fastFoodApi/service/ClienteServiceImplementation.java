package it.pegaso2000.fastFoodApi.service;

import java.util.List;
import java.util.Optional;

import it.pegaso2000.fastFoodApi.model.Cliente;
import it.pegaso2000.fastFoodApi.repo.ClienteRepo;

public class ClienteServiceImplementation implements ClienteService{

	private ClienteRepo crepo;
	
	@Override
	public List<Cliente> findAll() {
		return crepo.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return crepo.save(cliente);
	}

	@Override
	public Cliente findById(int id) {
		Optional<Cliente> c = crepo.findById(id);
		if(c.isPresent()) return c.get();
		return null;
	}

	@Override
	public boolean delete(int id) {
		Optional<Cliente> c = crepo.findById(id);
		if(c.isPresent()) {
			crepo.deleteById(id);
			return true;
		}
		return false;
	}

}
