package com.eet3107.inscripciones.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@EqualsAndHashCode @NoArgsConstructor
public class Materia {

	
	@Column(name="id_materia") @Id @GeneratedValue
	private Integer idMateria;
	
	@Column
	@Length(max=30)
	private String nombre;
	
	@ManyToMany
	private Set<Curso> curso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TrayectoriaAcademica pendiente;
	
	
	@ManyToMany(mappedBy="materiaNotas")
	private Set<MateriaAlumnoCursoDetail> detalleAlumno;
	
	@OneToMany(mappedBy="materia",cascade=CascadeType.ALL)
	private List<NotaTrimestral>notas;
	


	
	
}
