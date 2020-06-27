package com.eet3107.inscripciones.entidades;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

public class Persona implements Serializable{


	private static final long serialVersionUID = 1L;
	@Column
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	@NotBlank(message = "Este campo es obligatorio")
	private String nombre;
//
//	@Column
//	@NotBlank(message = "Este campo es obligatorio")
//	private String apellido;
//
	@Column
	@NotBlank(message = "Este campo es obligatorio")
	private String dni;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "IdDomicilio")
//	private Domicilio domicilio;
	

	

					
	
	

}
