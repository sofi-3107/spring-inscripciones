package com.eet3107.inscripciones.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@NoArgsConstructor @EqualsAndHashCode
public class TrayectoriaAcademica {
	
	@Id @Column 
	private Date fechaInscripcion;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "idLegajo")
	private Legajo legajo;
	
	@Column
	private String condicion;
	
	@OneToMany(mappedBy="inscripcion",cascade=CascadeType.ALL)
	private Set<Materia>materiasPendientes;

}
