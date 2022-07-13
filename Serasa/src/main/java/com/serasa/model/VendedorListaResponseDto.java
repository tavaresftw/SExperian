package com.serasa.model;

import org.hibernate.mapping.List;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
public class VendedorListaResponseDto {

	private String nome;
	private String telefone;
	private Integer idade;
	private String cidade;
	private String estado;
	private List estados;
	
}
