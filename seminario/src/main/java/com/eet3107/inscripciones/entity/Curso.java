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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

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
	
	@Column(length=2)
	private String nombre;
	
// para recuperar el plan de estudios vamos a concatenar nombre+ciclo
	
	@Column(length=2)
	private String division;
	
	@Column
	@Length(min=5,max=6)
	private Character turno;
	
	@Column
	@Length(min=6,max=8)
	private String ciclo;
	
	@Column
	@Min(value=12,message="Error edad mínima requerida es 12")
	@Max(value=25,message="Error, edad máxima admitida es 25")
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
