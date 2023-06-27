package it.pegaso2000.fastFoodApi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pegaso2000.fastFoodApi.dto.ClienteDto;
import it.pegaso2000.fastFoodApi.model.Cliente;
import it.pegaso2000.fastFoodApi.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

	private ClienteService service;

	@Autowired
	public ClienteController(ClienteService service) {
		super();
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<ClienteDto>> all() {
		List<Cliente> list = service.findAll();
		List<ClienteDto> result = list.stream().map(cliente -> {
			return entityToDto(cliente);
		}).collect(Collectors.toList());
		return new ResponseEntity<List<ClienteDto>>(result, HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<ClienteDto> findById(@PathVariable int id) {
		Cliente c = service.findById(id);
		if (c == null)
			return new ResponseEntity<ClienteDto>(HttpStatus.OK);
		ClienteDto dto = entityToDto(c);
		return new ResponseEntity<ClienteDto>(dto, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto dto) {
		Cliente saving = dtoToEntity(dto);
		Cliente saved = service.save(saving);
		return new ResponseEntity<ClienteDto>(entityToDto(saved), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public boolean delete(@PathVariable int id) {
		return service.delete(id);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<ClienteDto> update(@PathVariable int id, @RequestBody ClienteDto updated) {
		ClienteDto dto = entityToDto(service.findById(id));
		
		if (dto != null) {
			updated.setId(id);
			Cliente c = service.save(dtoToEntity(updated));
					return new ResponseEntity<ClienteDto>(entityToDto(c), HttpStatus.OK);

		}
		return new ResponseEntity<ClienteDto>(HttpStatus.NO_CONTENT);
	}

	private ClienteDto entityToDto(Cliente c) {
		ClienteDto dto = new ClienteDto();
		dto.setId(c.getId());
		dto.setNome(c.getNome());
		dto.setIs_vegetariano(c.isIs_vegetariano());
		dto.setEta(c.getEta());
		return dto;
	}

	private Cliente dtoToEntity(ClienteDto dto) {
		Cliente c = new Cliente();
		c.setNome(dto.getNome());
		c.setIs_vegetariano(dto.isIs_vegetariano());
		c.setEta(dto.getEta());
		return c;
	}

}
