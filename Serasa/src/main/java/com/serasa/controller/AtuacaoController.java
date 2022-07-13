package com.serasa.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.model.Atuacao;
import com.serasa.service.AtuacaoService;

@RestController
@RequestMapping("atuacao")
@Validated
public class AtuacaoController {


	@Autowired
	private AtuacaoService service;
	
	@PostMapping
	@Transactional
	@ResponseStatus(code = HttpStatus.CREATED)
	public Atuacao post(@RequestBody @Valid Atuacao atuacao) {
		return service.save(atuacao);
	}
	
}
