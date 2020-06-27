package com.eet3107.inscripciones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@EqualsAndHashCode @NoArgsConstructor
public class Materia {

	
	@Column @Id @GeneratedValue
	private Integer id;
	
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="fecha_inscripcion")
	private TrayectoriaAcademica inscripcion;
	
	@ManyToOne
	@JoinColumn(name="idCurso")
	private Curso curso;
	
	@Column
	private Integer[] notas=new Integer[3];
}
