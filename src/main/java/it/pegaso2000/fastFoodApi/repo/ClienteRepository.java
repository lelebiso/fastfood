package it.pegaso2000.fastFoodApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pegaso2000.fastFoodApi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
