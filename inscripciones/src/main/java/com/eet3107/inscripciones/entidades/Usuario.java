package com.eet3107.inscripciones.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Usuario {

	@Column(name="user_name")
	@Id
	@NotBlank
	private String userName;
	
	@NotBlank
	@Column(name="password")
	private String password;
	
	@NotBlank
	@Column
	private String rol;

}
