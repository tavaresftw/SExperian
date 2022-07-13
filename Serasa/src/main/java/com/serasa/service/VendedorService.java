package com.serasa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.serasa.exception.GeneralException;
import com.serasa.model.Vendedor;
import com.serasa.model.VendedorListaResponseDto;
import com.serasa.model.VendedorResponseDto;
import com.serasa.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository repository;

	public Vendedor save(Vendedor vendedor) {
		return repository.save(vendedor);
	}

	public VendedorResponseDto findById(Integer id) {
		Optional<Vendedor> optional = repository.findById(id);
		if (optional != null) {
			Vendedor detalhe = optional.get();
			VendedorResponseDto vendedor = setVendedorResponseDto(detalhe);
			return vendedor;
		}
		throw new GeneralException(HttpStatus.NO_CONTENT, "id: Vendedor não encontrado");
	}

	public VendedorResponseDto setVendedorResponseDto(Vendedor vendedor) {
		VendedorResponseDto response = new VendedorResponseDto();
		response.setNome(vendedor.getNome());
		response.setDataInclusao(vendedor.getDataInclusao());
		response.setEstados(vendedor.getAtuacao().getEstados());

		return response;

	}
	
	public List<VendedorListaResponseDto> findAll() {
		List<Vendedor> lista = repository.findAll();
		if (lista != null) {
			List<VendedorListaResponseDto> vendedores = converteLista(lista);
			return vendedores;
		}
		throw new GeneralException(HttpStatus.NO_CONTENT, "Nenhum vendedor não encontrado");
	}
	
	public List<VendedorListaResponseDto> converteLista(List<Vendedor> lista) {
		
		List<VendedorListaResponseDto> listaResposta = new ArrayList<>();
		
		for (Vendedor item : lista) {
			VendedorListaResponseDto vendedorLista = new VendedorListaResponseDto();
			
			vendedorLista.setNome(item.getNome());
			vendedorLista.setTelefone(item.getTelefone());
			vendedorLista.setIdade(item.getIdade());
			vendedorLista.setCidade(item.getCidade());
			vendedorLista.setEstado(item.getEstado());
			vendedorLista.setEstados(item.getAtuacao().getEstados());
			
			listaResposta.add(vendedorLista);
			
		}
		
		return listaResposta;
		
	}
	
}
