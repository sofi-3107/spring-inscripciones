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
	
	@Column(length=5)
	private String curso;
	
	@Column
	@Size(max=15)
	private String condicion;
	
	// recupera el plan de estudios para mostrar listado de materias pero solo guarda 2
	
	@OneToMany(mappedBy="pendiente" ,cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	List<Materia>pendientes; 

	
	
	

}
