package com.serasa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.mapping.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@ToString
@Entity(name="atuacao")
public class Atuacao {

	@ApiModelProperty(position=1, required=true)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ApiModelProperty(position=2, required=true)
	@NotBlank(message="obrigatório")
	@Size(max=100, message="máximo de 100 caracteres")
	private String regiao;
	
	@ApiModelProperty(position=3, required=true)
	@NotBlank(message="obrigatório")
	private List estados;
	
}
