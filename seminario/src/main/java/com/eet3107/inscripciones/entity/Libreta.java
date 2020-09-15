package com.eet3107.inscripciones.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@NoArgsConstructor
public class Libreta {

	
@Column @Id @GeneratedValue
private Integer idLibreta;

@Column(length=1)
private Integer trimestre;

@Column(length=2)
private Integer calificacion;

@JsonIgnore
@ManyToOne
@JoinColumn(name="alumno_trayectoria")
private TrayectoriaAcademica alumnoTyaFk;


@ManyToOne
@JoinColumn(name="curso_fk")
private Curso curso;


@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
@JoinTable(
		name="libreta_materias",
		joinColumns=@JoinColumn(name="id_libreta"),
		inverseJoinColumns=@JoinColumn(name="id_materia")
		)
private List<Materia>materias;

@Column(length=2)
private String anioLectivo;



}
