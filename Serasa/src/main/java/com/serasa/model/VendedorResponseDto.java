package com.serasa.model;

import java.util.Date;

import org.hibernate.mapping.List;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
public class VendedorResponseDto {

	private String nome;
	private Date dataInclusao;
	private List estados;
	
}
