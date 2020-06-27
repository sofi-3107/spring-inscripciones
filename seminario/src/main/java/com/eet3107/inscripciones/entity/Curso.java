package com.eet3107.inscripciones.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @EqualsAndHashCode
@Getter @Setter @NoArgsConstructor
public class Curso {
	
	@Id @Column @GeneratedValue
	private Integer id_curso;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy="curso",cascade=CascadeType.ALL)
	private  Set<Materia>planDeEstudios;
	
	@Column
	private String division;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private TrayectoriaAcademica cicloLectivoActual;
	
	@Column
	private Character turno;
	
	@Column
	private String ciclo;
	
	@Column
	private Integer edadMax;
	
	@Transient
	public static Integer cupoMax=25;
	
	
	public static Integer getCupoMax() {
		return cupoMax;
	}

}
