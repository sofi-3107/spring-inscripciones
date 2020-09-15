package com.eet3107.inscripciones.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class MateriaAlumnoCursoDetail {
	
	
	@Id @GeneratedValue
	private Integer IdAlMatDetail;	
	
	@Column(name="dni_alumno",length=8)
	private String alumno;
	
	@Column
	private Boolean isRepitente;
	
	
	@Column(length=2)
	private String nombreCurso;
	
	@Column(length=2)
	private String divisionCurso;
	
	@Column(length=8)
	private String cicloCurso;
	
	@Column(length=1)
	private Character turno;
	
	@Column(length=4)
	private String anioLectivo;
}
