package it.pegaso2000.fastFoodApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pegaso2000.fastFoodApi.model.Piatto;
import it.pegaso2000.fastFoodApi.repo.PiattoRepo;

@Service
public class PiattoServiceImplementation implements PiattoService{

	private PiattoRepo prepo;
	 
	@Autowired
	public PiattoServiceImplementation(PiattoRepo prepo) {
		super();
		this.prepo = prepo;
	}

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
