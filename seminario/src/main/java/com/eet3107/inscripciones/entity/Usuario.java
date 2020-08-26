package com.eet3107.inscripciones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Usuario {
	
	
	@Id @GeneratedValue
	private Integer idUsuario;
	
	
	@Column
	@Size(min=4,max=11,message="El nombre de usuario debe tener entre 4 y 11 caracteres")
	@Pattern(regexp ="^[a-zA-Z0-9]*$",message="El nombre de usuario debe tener solo números y/o letras, sin espacios")
	@NotBlank
	private String userName;
	
	
	@Column
	@Size(min=5,max=11,message="La contraseña debe tener un mínimo de 4 caracteres y máximo de 8")
	@NotBlank
	@Pattern(regexp ="^[a-zA-Z0-9]*$",message="La contraseña debe tener solo números y/o letras")
	private String password;
	
	@Column
	private String rol;

}
