package com.eet3107.inscripciones.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@NoArgsConstructor
@Getter @Setter @AllArgsConstructor
@ToString
public class TrayectoriaAcademica {
	


	@Id @GeneratedValue
	private Integer idInscripciones;
	
	@Column(length=10)
	@NotBlank
	private String fechaInscripcion;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="alumno_fk")
	private Alumno alumno;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="curso_fk")
	private Curso curso;
	
	
	@Column(length=4)
	private String anioLectivo;
	
	@Column
	@Size(max=15)
	private String condicion;
	
	@Column
	private Boolean isRepitente;
	
	@OneToMany(mappedBy="alumnoTyaFk",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Libreta>libretas;
	
	@OneToMany(mappedBy="pendiente" ,cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	List<Materia>pendientes; 

	
	
	

}
