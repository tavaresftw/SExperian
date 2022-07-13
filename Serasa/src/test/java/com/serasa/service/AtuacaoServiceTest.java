package com.serasa.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.serasa.model.Atuacao;
import com.serasa.repository.AtuacaoRepository;

@SpringBootTest(classes = AtuacaoService.class)
class AtuacaoServiceTest {

	@Autowired
	private AtuacaoService service;
	
	@MockBean(answer = Answers.RETURNS_MOCKS)
	protected AtuacaoRepository repo;
	
	@Test
	void salvar() {
		Atuacao atuacaoDto = Mockito.mock(Atuacao.class, Answers.RETURNS_MOCKS);
		
		Assertions.assertNotNull(service.save(atuacaoDto));
	}
	
	
}
