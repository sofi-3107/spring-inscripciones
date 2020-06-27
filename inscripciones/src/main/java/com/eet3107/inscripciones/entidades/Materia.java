package com.eet3107.inscripciones.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Materia {
	
	@Id
	@GeneratedValue
	@Column
	private Integer idMateria;
	
	@Column
	private String nombreMateria;
	
	@Column
	private Integer[] notas= new Integer[3];
	
	@ManyToOne
	private Curso  curso;


}
