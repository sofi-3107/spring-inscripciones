package com.eet3107.inscripciones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @EqualsAndHashCode
@Getter @Setter @NoArgsConstructor
public class Curso {
	


	@Id @Column
	@GeneratedValue
	private Integer idCurso;
	
	@Column(name="curso")
	@Size(max=2)
	private String nombreCurso;
	
	
	@Column
	private String division;
	
	@Column
	private String turno;
	
	@Column
	@Length(min=6,max=8)
	private String ciclo;
	
	@Column
	private Integer edadMax;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pe",unique=true)
	private PlanDeEstudios planE;
	
	@Transient
	public static Integer cupoMax=25;
	
	
	public static Integer getCupoMax() {
		return cupoMax;
	}



	
	

}
