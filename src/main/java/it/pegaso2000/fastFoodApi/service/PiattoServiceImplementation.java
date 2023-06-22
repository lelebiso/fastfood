package it.pegaso2000.fastFoodApi.service;

import java.util.List;
import java.util.Optional;

import it.pegaso2000.fastFoodApi.model.Piatto;
import it.pegaso2000.fastFoodApi.repo.PiattoRepo;

public class PiattoServiceImplementation implements PiattoService{

	private PiattoRepo prepo;
	
	@Override
	public List<Piatto> findAll() {
		return prepo.findAll();
	}

	@Override
	public Piatto save(Piatto piatto) {
		return prepo.save(piatto);
	}

	@Override
	public Piatto findById(int id) {
		Optional<Piatto> p = prepo.findById(id);
		if(p.isPresent()) return p.get();
		return null;
	}

	@Override
	public boolean delete(int id) {
		Optional<Piatto> p = prepo.findById(id);
		if(p.isPresent()) {
			prepo.deleteById(id);
			return true;
		}
		return false;
	}

}
