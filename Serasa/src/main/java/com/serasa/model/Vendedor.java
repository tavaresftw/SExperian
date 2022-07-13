package com.serasa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@ToString
@Entity(name="vendedor")
public class Vendedor {

	@ApiModelProperty(position=1, required=true)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ApiModelProperty(position=2)
	private Date dataInclusao = new Date();
	
	@ApiModelProperty(position=3, required=true)
	@NotBlank(message="obrigatório")
	@Size(max=100, message="máximo de 150 caracteres")
	private String nome;
	
	
	@ApiModelProperty(position=4, required=true)
	@NotBlank(message="obrigatório")
	@Size(min=13,max=13, message="formato deve ser como no exemplo: “99 99999-9999” ")
	@Pattern(regexp = "[A-Z]{1}.*", message="inválido") //criar regex com a mascara do telefone
	private String telefone;
	
	
	@ApiModelProperty(position=5, required=true)
	@NotBlank(message="obrigatório")
	@Min(value=18, message="valor mínimo 18")
	private Integer idade;
	
	
	@ApiModelProperty(position=6, required=true)
	@NotBlank(message="obrigatório")
	private String cidade;
	
	
	@ApiModelProperty(position=7, required=true)
	@NotBlank(message="obrigatório")
	@Size(min = 2, max=2, message="máximo de 2 caracteres")
	private String estado;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="regiao", nullable=true)
	private Atuacao atuacao ;
    
	@ApiModelProperty(position=8, required=true)
	@NotBlank(message="obrigatório")
	@Size(max=20, message="máximo de 20 caracteres")
	private String regiao;
	
}
