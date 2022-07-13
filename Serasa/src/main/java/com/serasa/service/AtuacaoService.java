package com.serasa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.model.Atuacao;
import com.serasa.repository.AtuacaoRepository;

@Service
public class AtuacaoService {

	@Autowired
	private AtuacaoRepository repository;

	public Atuacao save(Atuacao atuacao) {
		return repository.save(atuacao);
	}
	
}
