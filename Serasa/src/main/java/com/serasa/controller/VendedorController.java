package com.serasa.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.model.Vendedor;
import com.serasa.model.VendedorListaResponseDto;
import com.serasa.model.VendedorResponseDto;
import com.serasa.service.VendedorService;

@RestController
@RequestMapping("vendedor")
@Validated
public class VendedorController {

	@Autowired
	private VendedorService service;
	
	@PostMapping
	@Transactional
	@ResponseStatus(code = HttpStatus.CREATED)
	public Vendedor post(@RequestBody @Valid Vendedor vendedor) {
		return service.save(vendedor);
	}
	
	@GetMapping("vendedor/{id}")
	@Transactional
	@ResponseStatus(code = HttpStatus.OK)
	public VendedorResponseDto get(
			@PathVariable("id")
			@Valid
			@Min(value=1, message="valor mínimo 1") Integer id) {
		return service.findById(id);
	}
	
	@GetMapping
	@Transactional
	@ResponseStatus(code = HttpStatus.OK)
	public List<VendedorListaResponseDto> get() {
		return service.findAll();
	}
	
}
