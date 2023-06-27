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

import it.pegaso2000.fastFoodApi.dto.PiattoDto;
import it.pegaso2000.fastFoodApi.model.Piatto;
import it.pegaso2000.fastFoodApi.service.PiattoService;

@RestController
@RequestMapping("api/piatto")
public class PiattoController {

	private PiattoService service;

	@Autowired
	public PiattoController(PiattoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<PiattoDto>> all() {
		List<Piatto> list = service.findAll();
		List<PiattoDto> result = list.stream().map(piatto -> {
			return entityToDto(piatto);
		}).collect(Collectors.toList());
		return new ResponseEntity<List<PiattoDto>>(result, HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<PiattoDto> findById(@PathVariable int id) {
		Piatto c = service.findById(id);
		if (c == null)
			return new ResponseEntity<PiattoDto>(HttpStatus.OK);
		PiattoDto dto = entityToDto(c);
		return new ResponseEntity<PiattoDto>(dto, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<PiattoDto> save(@RequestBody PiattoDto dto) {
		Piatto saving = dtoToEntity(dto);
		Piatto saved = service.save(saving);
		return new ResponseEntity<PiattoDto>(entityToDto(saved), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public boolean delete(@PathVariable int id) {
		return service.delete(id);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<PiattoDto> update(@PathVariable int id, @RequestBody PiattoDto updated) {
		PiattoDto dto = entityToDto(service.findById(id));

		if (dto != null) {
			updated.setId(id);
			Piatto p = service.save(dtoToEntity(updated));
			return new ResponseEntity<PiattoDto>(entityToDto(p), HttpStatus.OK);

		}
		return new ResponseEntity<PiattoDto>(HttpStatus.NO_CONTENT);
	}

	private PiattoDto entityToDto(Piatto p) {
		PiattoDto dto = new PiattoDto();
		dto.setId(p.getId());
		dto.setIs_vegetariano(p.isIs_vegetariano());
		dto.setDescrizione(p.getDescrizione());
		dto.setPrezzo(p.getPrezzo());
		return dto;
	}

	private Piatto dtoToEntity(PiattoDto dto) {
		Piatto p = new Piatto();
		p.setDescrizione(dto.getDescrizione());
		p.setIs_vegetariano(dto.isIs_vegetariano());
		p.setPrezzo(dto.getPrezzo());
		return p;
	}
}
