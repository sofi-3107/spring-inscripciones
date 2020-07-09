package com.eet3107.inscripciones.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Setter @Getter
@NoArgsConstructor
public class PlanDeEstudios {


	@Id @Column(length=3)
	private String  id; // ejemplo 1ºCS
	
	@OneToOne(mappedBy="planE")
	private Curso curso;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="planDeEstudios",orphanRemoval=true)
	private Set<Materia>materias;
}
