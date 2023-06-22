package it.pegaso2000.fastFoodApi.service;


import java.util.List;

import it.pegaso2000.fastFoodApi.model.Piatto;

public interface PiattoService{

	List<Piatto> findAll();
	Piatto save(Piatto piatto);
	Piatto findById (int id);
	boolean delete (int id);

}
