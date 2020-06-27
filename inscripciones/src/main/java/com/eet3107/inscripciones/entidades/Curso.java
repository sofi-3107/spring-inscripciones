package com.eet3107.inscripciones.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
public class Curso {

	@Column
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String nombreCurso;
//	
//	@Column
//	private String division;
//	
//	@Column
//	private Character ciclo;
//	
//	@Column
//	private Character  turno;
//	
//	@Column
//	private  Character edadMáxima;
	
//	@OneToMany
//	private Set<Materia>planDeEstudios;
}
