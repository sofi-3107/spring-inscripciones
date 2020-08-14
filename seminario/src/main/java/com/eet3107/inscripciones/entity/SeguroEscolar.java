package com.eet3107.inscripciones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class SeguroEscolar {
	
	
	@Id @GeneratedValue
	private Integer idPagoIPS;
	
	@Column(length=5)
	private String  cursoFk;
	
	@Column(length=1)
	private Character turno;
	
	@Column(length=8)
	private String dniAlumno;
	
	
	@Column(length=10)
	@NotEmpty
	private String fecha;
	
	
	@Column
	private Double importe;

}
