package com.eet3107.inscripciones.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

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
	
	@Column(name="materias_fk")
	private Integer materias;
	
	@OneToMany(mappedBy="detalleAlumno",cascade=CascadeType.ALL)	
	private List<NotaTrimestral> nota;
	
	
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
