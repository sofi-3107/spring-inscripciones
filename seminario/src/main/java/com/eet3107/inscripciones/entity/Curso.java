package com.eet3107.inscripciones.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @EqualsAndHashCode
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class Curso {
	


	@Id @Column
	@GeneratedValue
	private Integer idCurso;
	
	@Column
	private String nombre;
	
// para recuperar el plan de estudios vamos a concatenar nombre+ciclo
	
	@Column
	private String division;
	
	@Column
	private Character turno;
	
	@Column
	private String ciclo;
	
	@Column
	private Integer edadMax;

	@OneToOne(fetch=FetchType.LAZY,optional=false,cascade=CascadeType.ALL)
	@JoinColumn(name="id",unique=true)
	private PlanDeEstudios planE;
	
	@Transient
	public static Integer cupoMax=25;
	
	
	public static Integer getCupoMax() {
		return cupoMax;
	}



	
	

}
