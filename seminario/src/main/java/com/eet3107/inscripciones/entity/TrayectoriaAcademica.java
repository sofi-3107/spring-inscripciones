package com.eet3107.inscripciones.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
 @EqualsAndHashCode
 @NoArgsConstructor
public class TrayectoriaAcademica {
	
	@Column @Id 
	@Length(max=15)
	private String fechaInscripcion;
	
	@ManyToOne
	@JoinColumn(name = "idLegajo")
	private Legajo legajo;
	
	@OneToOne
	@JoinColumn(name="idCurso")
	private Curso curso;
	
	@Column
	private String condicion;
	
	// recupera el plan de estudios para mostrar listado de materias pero solo guarda 2
	
	@OneToMany(mappedBy="pendiente" ,cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	List<Materia>pendientes; 

	
	
	

}
