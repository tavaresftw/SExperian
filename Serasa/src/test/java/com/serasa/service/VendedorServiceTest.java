package com.serasa.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.serasa.exception.GeneralException;
import com.serasa.model.Vendedor;
import com.serasa.model.VendedorListaResponseDto;
import com.serasa.repository.VendedorRepository;

@SpringBootTest(classes = VendedorService.class)
public class VendedorServiceTest {
	
	@Autowired
	private VendedorService service;
	
	@MockBean(answer = Answers.RETURNS_MOCKS)
	protected VendedorRepository repo;
	
	@MockBean(answer = Answers.RETURNS_MOCKS)
	private List<Vendedor> mockedVendedores;

	@MockBean(answer = Answers.RETURNS_MOCKS)
	private List<VendedorListaResponseDto> mockedVendedoresListaResponseDto;
	
	@Test
	void salvar() {
		Vendedor vendedorDto = Mockito.mock(Vendedor.class, Answers.RETURNS_MOCKS);
		
		Assertions.assertNotNull(service.save(vendedorDto));
	}
	
	@Test
	void buscaPorId() {
		Optional<Vendedor> vendedor = Optional.empty();
		
		Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(vendedor);
		
		Assertions.assertThrows(GeneralException.class, ()->service.findById(Mockito.anyInt()) );
		
	}
	
	@Test 
	void setaValoresResponseVendedor() {
		
		Vendedor vendedorDto = Mockito.mock(Vendedor.class, Answers.RETURNS_MOCKS);
		
		Assertions.assertNotNull(service.setVendedorResponseDto(vendedorDto));
	}
	
	@Test
	void listaGeralException() {
		
		List<Vendedor> lista = null;
		
		Mockito.when(repo.findAll()).thenReturn(lista);
		
		Assertions.assertThrows(GeneralException.class, ()->service.findAll());
		
	}
	
	@Test()
	void converteListaVendedores() {
		
		Assertions.assertNotNull(service.converteLista(mockedVendedores));
		
	}
	
}
